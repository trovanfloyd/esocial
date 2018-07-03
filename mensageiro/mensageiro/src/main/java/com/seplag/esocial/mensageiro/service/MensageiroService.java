package com.seplag.esocial.mensageiro.service;

import java.io.ByteArrayInputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.seplag.esocial.mensageiro.config.SOAPConnector;
import com.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import com.seplag.esocial.mensageiro.repository.MensageiroRepository;
import com.seplag.esocial.mensageiro.schemas.EnviarLoteEventos;
import com.seplag.esocial.mensageiro.schemas.EnviarLoteEventos.LoteEventos;
import com.seplag.esocial.mensageiro.schemas.EnviarLoteEventosResponse;
import com.seplag.esocial.mensageiro.util.SSLUtil;

@Service
public class MensageiroService {

	@Autowired
	SOAPConnector soapConnector;

	@Autowired
	MensageiroRepository mensageiroRepository;

	public void send() {
		EnviarLoteEventos loteEventos = popularLote();

		try {
			SSLUtil.turnOffSslChecking();
		}
		catch (KeyManagementException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		EnviarLoteEventosResponse response = (EnviarLoteEventosResponse) soapConnector.callWebService(
		        "https://webservices.envio.esocial.gov.br/servicos/empregador/enviarloteeventos/WsEnviarLoteEventos.svc", loteEventos);

		System.out.println(response.getEnviarLoteEventosResult());
	}

	private EnviarLoteEventos popularLote() {
		EnviarLoteEventos enviarLoteEventos = new EnviarLoteEventos();

		LoteEventos loteEventos = new LoteEventos();
		loteEventos.setAny(find());

		enviarLoteEventos.setLoteEventos(loteEventos);

		return enviarLoteEventos;
	}

	private Element find() {
		List<ArquivoEsocial> listArquivo = (List<ArquivoEsocial>) mensageiroRepository.findAll();
		ArquivoEsocial arq = listArquivo.get(0);

		String xml = new String(arq.getArquivo());

		// System.out.println(xml);

		Element retorno = getElement(arq.getArquivo());

		return retorno;

	}

	private Element getElement(byte[] xml) {
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new ByteArrayInputStream(xml));

			return doc.getDocumentElement();
		}
		catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
