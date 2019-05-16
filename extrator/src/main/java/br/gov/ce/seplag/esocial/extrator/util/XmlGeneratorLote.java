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

package br.gov.ce.seplag.esocial.extrator.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
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

import com.stratumsoft.xmlgen.DefaultValues;
import com.stratumsoft.xmlgen.SchemaTypeXmlGenerator;
import com.stratumsoft.xmlgen.XmlGenOptions;

/**
 * @author murakris@stratumsoft.com
 * @since 9/7/11 (1.0)
 */
public class XmlGeneratorLote {

	String BASE_URI = "/schemas/";

	// String BASE_XSD = "ns1:";
	String BASE_XSD = "esocial:";

	String id = "";

	XmlSchemaCollection coll;
	private XmlSchema schema;
	private XmlGenOptions options;

	private SchemaTypeXmlGenerator generator;

	private static final Logger logger = LoggerFactory.getLogger(SchemaTypeXmlGenerator.class);

	public String testGenXml(List<String> xmlSigned) throws Exception {
		String xsdPath = "EnvioLoteEventos-v1_1_1.xsd";

		String xsltPath = "removeNs.xslt";
		// String xsdPath = "catalog.xsd";

		String path = BASE_URI + xsdPath;
		String pathXslt = BASE_URI + xsltPath;

		InputStream is = this.getClass().getResourceAsStream(path);
		InputStream isXslt = this.getClass().getResourceAsStream(pathXslt);

		URL xsdUrl = this.getClass().getResource(path);

		coll = new XmlSchemaCollection();
		coll.setBaseUri(xsdUrl.toString());

		StreamSource source = new StreamSource(is);
		Source sourceXslt = new StreamSource(isXslt);

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
		xml = ExtratorUtil.format(xml, true);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xml)));
		Element rootElement = document.getDocumentElement();

		setId(null, rootElement);
		setValue("tpInsc_ideEmpregador", rootElement, "1");
		setValue("nrInsc_ideEmpregador", rootElement, "08691976");
		setValue("tpInsc_ideTransmissor", rootElement, "1");
		setValue("nrInsc_ideTransmissor", rootElement, "08691976000160");

		for (int i = 0; i < xmlSigned.size(); i++) {
			if (i == 0) {
				insertXmlSigned(xmlSigned.get(i), document, rootElement, false);
				
			} else {
				insertXmlSigned(xmlSigned.get(i), document, rootElement, true);
			}
		}

		// setString(BASE_XSD + "evento", rootElement, xmlSigned);

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

		// Formata para XML
		// output = StringEscapeUtils.unescapeXml(output);
		// Retira comentários do XML
		// output = output.replaceAll("(?s)<!--.*?-->", "");
		// Retira prefix esocial
		// output = output.replaceAll("esocial:", "");
		// output = output.replaceAll(":esocial", "");

		// System.out.println(output);

		// return ExtratorUtil.format(output, true);
		return output;

	}

	private void insertXmlSigned(String xmlSigned, Document document, Element rootElement, boolean duplicate) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xmlSigned)));
		Element ele = doc.getDocumentElement();
		Node firstDocImportedNode = document.importNode(ele, true);
		
		if (duplicate) {
			Element element = duplicateNode("evento", rootElement);
			element.appendChild(firstDocImportedNode);
		} else {
			
			NodeList list = rootElement.getElementsByTagName("evento");
			if (list != null && list.getLength() > 0) {
				NodeList subList = list.item(0).getChildNodes();
				
				if (subList != null && subList.getLength() > 0) {
					subList.item(0).getParentNode().appendChild(firstDocImportedNode);
				} else {
					list.item(0).appendChild(firstDocImportedNode);
				}
			}
		}
		
	}

	private void createNewRootElement(Document document, String nameSpace, String tagname) {
		Element newRoot = document.createElementNS(nameSpace, tagname);
		newRoot.appendChild(document.getFirstChild());
		document.appendChild(newRoot);
	}

	private void setId(HashMap<String, String> xmlValues, Element rootElement) {
		// id = xmlValues.get("id");
		NodeList list = rootElement.getElementsByTagName("evento");
		if (list != null && list.getLength() > 0) {
			NamedNodeMap attr = list.item(0).getAttributes();
			setAttribute(attr);
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

	protected void setString(String tagName, Element element, String value) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			NodeList subList = list.item(0).getChildNodes();

			if (subList != null && subList.getLength() > 0) {
				subList.item(0).setNodeValue(value);

			}
		}

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
					// System.out.println(list.item(i).getParentNode().getNodeName());
					System.out.println("tag name duplicado: " + tagName);
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

	protected void setAttribute(NamedNodeMap attr) {
		if (attr != null) {
			Node node = attr.getNamedItem("Id");
			if (node != null) {
				node.setNodeValue("ID1086919760000002018070908201000002");
				// node.setNodeValue("ID1006710770000002018070908201000002");

			}
		}

	}

	protected void removeNode(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			element.removeChild(list.item(0));
			/*
			 * NodeList subList = list.item(0).getChildNodes();
			 *
			 * if (subList != null && subList.getLength() > 0) {
			 * element.removeChild(subList.item(0));
			 *
			 * }
			 */
		}

	}
	
	protected Element duplicateNode(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName.split("_")[1]);
		if (list != null && list.getLength() > 0) {
			// list.item(0).getParentNode().appendChild(list.item(0).cloneNode(true));

			Node n = list.item(0).getParentNode().insertBefore(list.item(0).cloneNode(true), list.item(0).getPreviousSibling());

			return (Element) n;

		}

		return null;
	}

}
