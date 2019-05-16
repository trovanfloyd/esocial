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

package com.stratumsoft.xmlgen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import br.gov.ce.seplag.esocial.extrator.entity.S1000;

/**
 * @author murakris@stratumsoft.com
 * @since 9/7/11 (1.0)
 */
public class SampleXmlGenerator {

	String BASE_URI = "/schemas/";

	String BASE_XSD = "ns1:";

	XmlSchemaCollection coll;
	private XmlSchema schema;
	private XmlGenOptions options;

	private SchemaTypeXmlGenerator generator;

	private static final Logger logger = LoggerFactory.getLogger(SchemaTypeXmlGenerator.class);

	@Test
	public void testGenXml() throws Exception {
		String xsdPath = "evtInfoEmpregador.xsd";
		// String xsdPath = "catalog.xsd";

		String path = BASE_URI + xsdPath;
		InputStream is = this.getClass().getResourceAsStream(path);
		assertNotNull(is);

		URL xsdUrl = this.getClass().getResource(path);

		coll = new XmlSchemaCollection();
		coll.setBaseUri(xsdUrl.toString());

		StreamSource source = new StreamSource(is);
		schema = coll.read(source);
		assertNotNull(schema);

		options = new XmlGenOptions();
		options.setGenCommentsForParticles(true);
		options.setGenChoiceOptionsAsComments(false);
		options.setMaxRecursiveDepth(1);
		options.setMaxRepeatingElements(2);
		options.setDefVals(DefaultValues.DEFAULT);

		generator = new SchemaTypeXmlGenerator(coll, options);

		QName elName = new QName("http://www.esocial.gov.br/schema/evt/evtInfoEmpregador/v02_04_02", "eSocial");

		String xml = generator.generateXml(elName, true);

		assertNotNull(xml);
		assertTrue(xml.length() > 0);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xml)));
		Element rootElement = document.getDocumentElement();

		S1000 s1000 = popular();

		//setString(BASE_XSD + "nrSiafi", rootElement, s1000.getNrSiafi());
		String requestQueueName = getString(BASE_XSD + "nrSiafi", rootElement);

		System.out.println(requestQueueName);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(document), new StreamResult(writer));
		String output = writer.getBuffer().toString();

		System.out.println(output);

	}

	private S1000 popular() {
		S1000 s1000 = new S1000();
		//s1000.setIniValid("teste");
		//s1000.setNrSiafi("15151");

		return s1000;
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

	private String getFieldName(String method) {
		String result = method.split(".")[1].replaceAll("get", "");
		result = result.substring(0, 1).toLowerCase() + result.substring(1);

		return result;

	}
}
