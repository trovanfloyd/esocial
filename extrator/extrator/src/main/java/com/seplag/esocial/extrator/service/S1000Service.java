package com.seplag.esocial.extrator.service;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.seplag.esocial.extrator.entity.ArquivoEsocial;
import com.seplag.esocial.extrator.entity.S1000;
import com.seplag.esocial.extrator.repository.S1000Repository;
import com.seplag.esocial.extrator.util.ExtratorUtil;
import com.seplag.esocial.extrator.util.XmlGenerator;
import com.seplag.esocial.extrator.util.XmlGeneratorLote;

@Service
public class S1000Service {

	@Autowired
	S1000Repository s1000Repository;

	@Autowired
	AssinadorService assinadorService;

	@Autowired
	ArquivoEsocialService arquivoEsocialService;

	Map<String, Object> mapXml;

	public Iterable<S1000> findAll() {
		return s1000Repository.findAll();
	}

	public String executeXml() {

		List<String> xml = new ArrayList<>();

		List<S1000> listS1000 = (List<S1000>) s1000Repository.findAll();

		S1000 s = listS1000.get(0);
		listS1000.clear();
		listS1000.add(s);

		// mapXml = ExtratorUtil.mapFields(S1000.class);

		// mapXml = ExtratorUtil.mapFields(S1000.class);

		listS1000.forEach(s1000 -> {

			// mapXml = ExtratorUtil.mapValueOnFields(s1000, mapXml);

			mapXml = ExtratorUtil.mapValueOnFields(s1000, null);

			try {

				XmlGenerator xmlGenerator = new XmlGenerator();
				// xml.add(xmlGenerator.testGenXml(mapXml));

				Document doc = xmlGenerator.testGenXml(mapXml, "evtInfoEmpregador.xsd", "evtInfoEmpregador");
				Document docSigned = assinadorService.signDocument(doc);

				XmlGeneratorLote generatorLote = new XmlGeneratorLote();
				String xmlLote = generatorLote.testGenXml(getXml(docSigned));
				// String xmlLote = getXml(doc);
				xml.add(xmlLote);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});

		System.out.println("fim");

		createAndSaveArquivoEsocial(xml.get(0));

		return xml.get(0);
	}

	private String getXml(Document document) {

		String output = "";

		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
			// "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	private void createAndSaveArquivoEsocial(String arquivoEsocial) {
		ArquivoEsocial arq = new ArquivoEsocial();
		arq.setArquivo(arquivoEsocial.getBytes());
		arq.setDataCriacao(new Date());
		arq.setDescricao("arquivo S1000 teste");

		arquivoEsocialService.save(arq);
	}
}
