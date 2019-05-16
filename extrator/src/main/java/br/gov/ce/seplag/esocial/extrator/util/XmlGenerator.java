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

import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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

import com.stratumsoft.xmlgen.DefaultValues;
import com.stratumsoft.xmlgen.SchemaTypeXmlGenerator;
import com.stratumsoft.xmlgen.XmlGenOptions;

/**
 * @author murakris@stratumsoft.com
 * @since 9/7/11 (1.0)
 */
public class XmlGenerator {

	String BASE_URI = "/schemas/";

	String id = "";

	XmlSchemaCollection coll;
	private XmlSchema schema;
	private XmlGenOptions options;

	private SchemaTypeXmlGenerator generator;

	private static final Logger logger = LoggerFactory.getLogger(SchemaTypeXmlGenerator.class);

	public Document gerarXML(Map<String, Object> xmlValues, String xsdPath, String tag, String idEvento) throws Exception {

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

		QName elName = new QName("http://www.esocial.gov.br/schema/evt/" + tag + "/v02_04_02", "eSocial");

		String xml = generator.generateXml(elName, true);
		xml = ExtratorUtil.format(xml, true);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xml)));
		Element rootElement = document.getDocumentElement();

		// Remove this node because it will be add on the sign module
		removeNode("ds:Signature", rootElement);

		setId(tag ,idEvento, rootElement);

		xmlValues.forEach((k, v) -> {

			String value = "";
			if (v != null) {
				value = v.toString();
			}

			System.out.println("chave: " + k + " valor: " + value);

			if (k.contains("list")) {
				System.out.println("the is a list");
				setListValues(rootElement, k, v);
			}

			setValue(k, rootElement, value);

		});

		removeEmptyNodes(rootElement);

		return document;

	}

	private int i;
	private Element element;

	@SuppressWarnings("unchecked")
	private void setListValues(Element rootElement, String k, Object v) {
		if (k.contains("list")) {

			if (v instanceof List<?>) {

				i = 0;
				element = null;

				((List) v).forEach(o -> {

					if (i > 0) {
						element = duplicateNode(k, rootElement);
					} else {
						element = rootElement;
					}
					// Element element = duplicateNode(k, rootElement);

					Map<String, Object> mapXml = ExtratorUtil.mapValueOnFields(o, null);

					mapXml.forEach((k1, v1) -> {
						if (v1 != null) {

							setValue(k1, element, v1.toString());
						}
					});

					i++;

				});

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

	private void setId(String tag, String idEvento , Element rootElement) {
		NodeList list = rootElement.getElementsByTagName(tag);
		if (list != null && list.getLength() > 0) {
			NamedNodeMap attr = list.item(0).getAttributes();
			if (attr != null) {
				Node node = attr.getNamedItem("Id");
				if (node != null) {
					node.setNodeValue(idEvento);
				}
			}
		}
	}


	protected void removeNode(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			element.removeChild(list.item(0));
		}

	}


	public void removeEmptyNodes(Node node) {

		NodeList list = node.getChildNodes();
		List<Node> nodesToRecursivelyCall = new LinkedList();

		for (int i = 0; i < list.getLength(); i++) {
			nodesToRecursivelyCall.add(list.item(i));
		}

		for (Node tempNode : nodesToRecursivelyCall) {
			removeEmptyNodes(tempNode);
		}

		boolean emptyElement = node.getNodeType() == Node.ELEMENT_NODE && node.getChildNodes().getLength() == 0;
		boolean emptyText = node.getNodeType() == Node.TEXT_NODE && node.getNodeValue().trim().isEmpty();

		if (emptyElement || emptyText) {
			if (!node.hasAttributes()) {
				node.getParentNode().removeChild(node);
			}
		}

	}

	protected Element duplicateNode(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName.split("_")[1]);
		if (list != null && list.getLength() > 0) {

			Node n = list.item(0).getParentNode().insertBefore(list.item(0).cloneNode(true), list.item(0).getPreviousSibling());

			return (Element) n;

		}

		return null;
	}

}
