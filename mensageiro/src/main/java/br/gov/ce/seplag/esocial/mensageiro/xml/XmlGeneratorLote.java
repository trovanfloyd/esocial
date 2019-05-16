/*
 * Copyright (c) 2010-2014 Stratumsoft Technologies Pvt. Ltd.
 *
 * This file (SampleXmlGenerator.java) is part of xsd2xml.
 *
 * xsd2xml is a Java program to generate XML instances from an XML Schema document
 *
 * xsd2xml is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * xsd2xml is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 *
 * To use xsd2xml in your non-GPL licensed software, contact Stratumsoft Technologies
 * support at support@stratumsoft.com or visit http://www.stratumsoft.com to obtain
 * a commercial license.
 */

package br.gov.ce.seplag.esocial.mensageiro.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.gov.ce.seplag.esocial.mensageiro.util.MensageiroUtil;

/**
 * @author murakris@stratumsoft.com
 * @since 9/7/11 (1.0)
 */
public class XmlGeneratorLote {

	private static final String NUM_INSCRICAO_TRANSMISSOR = "08691976000160";

	private static final String NUM_INSCRICAO_EMPREGADOR = "08691976";

	private static final String TIPO_INSCRICAO = "1";

	String BASE_URI = "/schemas/";

	// String BASE_XSD = "ns1:";
	String BASE_XSD = "esocial:";

	String id = "";

	XmlSchemaCollection coll;
	private XmlSchema schema;
	private XmlGenOptions options;

	private SchemaTypeXmlGenerator generator;

	private static final Logger logger = LoggerFactory.getLogger(SchemaTypeXmlGenerator.class);

	public String gerarXmlLote(Map<String, String> listXmlSigned, String nrInscLote) throws Exception {
		String xsdPath = "EnvioLoteEventos-v1_1_1.xsd";

		String path = BASE_URI + xsdPath;

		InputStream is = this.getClass().getResourceAsStream(path);

		URL xsdUrl = this.getClass().getResource(path);

		coll = new XmlSchemaCollection();
		coll.setBaseUri(xsdUrl.toString());

		StreamSource source = new StreamSource(is);

		schema = coll.read(source);

		options = new XmlGenOptions();
		options.setGenCommentsForParticles(true);
		options.setGenChoiceOptionsAsComments(false);
		options.setMaxRecursiveDepth(1);
		options.setMaxRepeatingElements(1);
		options.setDefVals(DefaultValues.DEFAULT);

		generator = new SchemaTypeXmlGenerator(coll, options);

		QName elName = new QName("http://www.esocial.gov.br/schema/lote/eventos/envio/v1_1_1", "eSocial");

		String xml = generator.generateXml(elName, true);
		xml = MensageiroUtil.formatXML(xml, true);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xml)));
		Element rootElement = document.getDocumentElement();

		setValue("tpInsc_ideEmpregador", rootElement, TIPO_INSCRICAO);
		setValue("nrInsc_ideEmpregador", rootElement, nrInscLote);
		setValue("tpInsc_ideTransmissor", rootElement, TIPO_INSCRICAO);
		setValue("nrInsc_ideTransmissor", rootElement, NUM_INSCRICAO_TRANSMISSOR);

		if (listXmlSigned != null && listXmlSigned.size() > 1) {
			
			duplicateNode("evento", rootElement, listXmlSigned.size());
			
			int i = 0;
			for (Map.Entry<String, String> entry : listXmlSigned.entrySet()) {
				insertXmlSigned(entry.getValue(), document, rootElement, i);
				setId(entry.getKey(), rootElement, i);
				i++;
			}
			
		} else {
			for (Map.Entry<String, String> entry : listXmlSigned.entrySet()) {
				insertXmlSigned(entry.getValue(), document, rootElement, 0);
				setId(entry.getKey(), rootElement, 0);
			}
		}
		
		

		createNewRootElement(document, "http://www.esocial.gov.br/servicos/empregador/lote/eventos/envio/v1_1_1", "loteEventos");
		createNewRootElement(document, "http://www.esocial.gov.br/servicos/empregador/lote/eventos/envio/v1_1_0", "EnviarLoteEventos");

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "no");

		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(document), new StreamResult(writer));
		String output = writer.getBuffer().toString();

		return output;

	}

	private void insertXmlSigned(String xmlSigned, Document document, Element rootElement, int posicaoEvento) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xmlSigned)));
		Element ele = doc.getDocumentElement();
		Node firstDocImportedNode = document.importNode(ele, true);
		
			
		NodeList list = rootElement.getElementsByTagName("evento");
		if (list != null && list.getLength() > 0) {
			
			list.item(posicaoEvento).appendChild(firstDocImportedNode);
			
		}
		
	}

	private void createNewRootElement(Document document, String nameSpace, String tagname) {
		Element newRoot = document.createElementNS(nameSpace, tagname);
		newRoot.appendChild(document.getFirstChild());
		document.appendChild(newRoot);
	}


	private void setId(String idEvento, Element rootElement, Integer posicaoEvento) {
		NodeList list = rootElement.getElementsByTagName("evento");
		if (list != null && list.getLength() > 0) {
			NamedNodeMap attr = list.item(posicaoEvento).getAttributes();
			if (attr != null) {
				Node node = attr.getNamedItem("Id");
				if (node != null) {
					node.setNodeValue(idEvento);
				}
			}
		}
	}
	
	protected String getString(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {

			NodeList subList = list.item(0).getChildNodes();

			if (subList != null && subList.getLength() > 0) {
				return subList.item(0).getNodeValue();
			}
		}

		return null;
	}


	protected void setValue(String tagName, Element element, String value) {

		String tagNameTemp = tagName;

		if (tagName.contains("_")) {
			tagNameTemp = tagName.split("_")[0];
		}

		NodeList list = element.getElementsByTagName(tagNameTemp);

		if (list != null && list.getLength() > 0) {

			NodeList subList = null;

			if (list.getLength() > 1) {
				for (int i = 0; i < list.getLength(); i++) {
					if (list.item(i).getParentNode().getNodeName().equalsIgnoreCase(tagName.split("_")[1])) {
						subList = list.item(i).getChildNodes();
					}
				}
			} else {
				subList = list.item(0).getChildNodes();
			}

			if (subList != null && subList.getLength() > 0) {
				subList.item(0).setNodeValue(value);

			}

		}

	}


	protected void removeNode(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			element.removeChild(list.item(0));
		}

	}
	
	protected void duplicateNode(String tagName, Element element, int qtdEvento) {
		
		for (int i = 0; i < qtdEvento - 1; i++) {
			
			NodeList list = element.getElementsByTagName(tagName);
			if (list != null && list.getLength() > 0) {
				
				list.item(0).getParentNode().insertBefore(list.item(0).cloneNode(true), list.item(0).getPreviousSibling());
				
			}
		}

	}

}
