package br.gov.ce.seplag.esocial.mensageiro.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class MensageiroUtil {

	public static String formatXML(String xml, Boolean ommitXmlDeclaration) throws IOException, SAXException, ParserConfigurationException {

		// Formata para XML
		xml = StringEscapeUtils.unescapeXml(xml);
		// Retira comentários do XML
		xml = xml.replaceAll("(?s)<!--.*?-->", "");
		// Retira prefix esocial
		xml = xml.replaceAll("esocial:", "");
		xml = xml.replaceAll(":esocial", "");

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
	
	public static Element getElement(byte[] xml) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new ByteArrayInputStream(xml));
			return doc.getDocumentElement();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static String getValueFromElement(String tagName, Element element) {

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
				return subList.item(0).getNodeValue();

			}

		}

		 return null;
	}
	
	public static String getXmlRetorno(Object any) {
		try {
			Element element = (Element) any;
			//document from a Element
			Document document = element.getOwnerDocument();
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public static InputStream getInputStream(Object any) {
		try {
			Element element = (Element) any;
			//document from a Element
			Document document = element.getOwnerDocument();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			transformer.transform(new DOMSource(document), new StreamResult(outputStream));
			InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			
			return inputStream;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static  <T> Collection<List<T>> partition(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger(0);

        return list.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values();
    }
}
