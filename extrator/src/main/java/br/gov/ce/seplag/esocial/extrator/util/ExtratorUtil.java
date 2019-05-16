package br.gov.ce.seplag.esocial.extrator.util;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class ExtratorUtil {


	public static Map<String, Object> mapValueOnFields(Object source, HashMap<String, String> mapXml) {

		BeanWrapperImpl bwSource = new BeanWrapperImpl(source);
		PropertyDescriptor[] propertyDescriptors = bwSource.getPropertyDescriptors();

		Map<String, Object> mappedObject = Stream.of(propertyDescriptors).collect(HashMap::new, (m, v) -> m.put(v.getName(), bwSource.getPropertyValue(v.getName())),
		        HashMap::putAll);

		return mappedObject;

	}


	public static String format(String xml, Boolean ommitXmlDeclaration) throws IOException, SAXException, ParserConfigurationException {

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
	

}
