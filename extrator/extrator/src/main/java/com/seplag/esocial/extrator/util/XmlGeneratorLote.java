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

package com.seplag.esocial.extrator.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;

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

import org.apache.commons.lang.StringEscapeUtils;
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
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * @author murakris@stratumsoft.com
 * @since 9/7/11 (1.0)
 */
public class XmlGeneratorLote {

	String BASE_URI = "/schemas/";

	// String BASE_XSD = "ns1:";
	String BASE_XSD = "";

	String id = "";

	XmlSchemaCollection coll;
	private XmlSchema schema;
	private XmlGenOptions options;

	private SchemaTypeXmlGenerator generator;

	private static final Logger logger = LoggerFactory.getLogger(SchemaTypeXmlGenerator.class);

	public String testGenXml(String xmlSigned) throws Exception {
		String xsdPath = "EnvioLoteEventos-v1_1_1.xsd";
		// String xsdPath = "catalog.xsd";

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

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xml)));
		Element rootElement = document.getDocumentElement();

		setString("esocial:evento", rootElement, xmlSigned);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.INDENT, "no");

		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(document), new StreamResult(writer));
		String output = writer.getBuffer().toString();

		// Formata para XML
		output = StringEscapeUtils.unescapeXml(output);
		// Retira comentários do XML
		output = output.replaceAll("(?s)<!--.*?-->", "");
		// System.out.println(output);

		return format(output, true);

	}

	private void setId(HashMap<String, String> xmlValues, Element rootElement) {
		id = xmlValues.get("id");
		NodeList list = rootElement.getElementsByTagName("evtInfoEmpregador");
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

	protected void setAttribute(NamedNodeMap attr) {
		if (attr != null) {
			Node node = attr.getNamedItem("Id");
			if (node != null) {
				node.setNodeValue(id);
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

	public static String format(String xml, Boolean ommitXmlDeclaration) throws IOException, SAXException, ParserConfigurationException {

		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xml)));

		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);
		format.setIndent(2);
		format.setOmitXMLDeclaration(ommitXmlDeclaration);
		format.setLineWidth(Integer.MAX_VALUE);
		Writer outxml = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(outxml, format);
		serializer.serialize(doc);

		return outxml.toString();

	}

}
