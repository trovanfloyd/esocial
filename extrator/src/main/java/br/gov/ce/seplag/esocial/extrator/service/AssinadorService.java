package br.gov.ce.seplag.esocial.extrator.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

@Service
public class AssinadorService {

	private final RestTemplate restTemplate;

	public AssinadorService(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}

	public Document signDocument(Document document) {
		Document docSigned = restTemplate.postForObject("http://localhost:9000/api/esocial/assinador/sign", document, Document.class);
		return docSigned;
	}
}
