package br.gov.ce.seplag.esocial.mensageiro.config;

import java.io.IOException;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

@Configuration
public class Config {

	private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

	@Value("${server.ssl.key-store}")
	private Resource keyStore;

	@Value("${server.ssl.key-store-password}")
	private String keyStorePassword;

	@Value("${server.ssl.trust-store}")
	private Resource trustStore;

	@Value("${server.ssl.trust-store-password}")
	private String trustStorePassword;
	
	@Value("${ws.enviar.lote.eventos.prod.restrita}")
	private String wsEnvioProducaoRestrita;
	
	@Value("${ws.consultar.lote.eventos.prod.restrita}")
	private String wsConsultaProducaoRestrita;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this is the package name specified in the <generatePackage> specified
		// in
		// pom.xml
		//marshaller.setContextPath("br.gov.ce.seplag.esocial.mensageiro.schemas");
		marshaller.setPackagesToScan("br.gov.ce.seplag.esocial.mensageiro.schemas");
		return marshaller;
	}

	@Bean
	public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
		SOAPConnector client = new SOAPConnector();
		client.setDefaultUri(wsEnvioProducaoRestrita);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);

		try {

			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(keyStore.getInputStream(), keyStorePassword.toCharArray());

			LOGGER.info("Loaded keystore: " + keyStore.getURI().toString());
			try {
				keyStore.getInputStream().close();
			}
			catch (IOException e) {}
			KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			keyManagerFactory.init(ks, keyStorePassword.toCharArray());

			KeyStore ts = KeyStore.getInstance("JKS");
			ts.load(trustStore.getInputStream(), trustStorePassword.toCharArray());
			LOGGER.info("Loaded trustStore: " + trustStore.getURI().toString());
			try {
				trustStore.getInputStream().close();
			}
			catch (IOException e) {}
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(ts);

			HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();
			messageSender.setKeyManagers(keyManagerFactory.getKeyManagers());
			messageSender.setTrustManagers(trustManagerFactory.getTrustManagers());

			// otherwise: java.security.cert.CertificateException: No name
			// matching localhost found
			messageSender.setHostnameVerifier((hostname, sslSession) -> {
				if (hostname.equals("localhost")) {
					return true;
				}
				return false;
			});

			client.setMessageSender(messageSender);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return client;
	}
	
	@Bean
	public SOAPConnectorConsulta soapConnectorConsulta(Jaxb2Marshaller marshaller) {
		SOAPConnectorConsulta client = new SOAPConnectorConsulta();
		client.setDefaultUri(wsConsultaProducaoRestrita);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);

		try {

			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(keyStore.getInputStream(), keyStorePassword.toCharArray());

			LOGGER.info("Loaded keystore: " + keyStore.getURI().toString());
			try {
				keyStore.getInputStream().close();
			}
			catch (IOException e) {}
			KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			keyManagerFactory.init(ks, keyStorePassword.toCharArray());

			KeyStore ts = KeyStore.getInstance("JKS");
			ts.load(trustStore.getInputStream(), trustStorePassword.toCharArray());
			LOGGER.info("Loaded trustStore: " + trustStore.getURI().toString());
			try {
				trustStore.getInputStream().close();
			}
			catch (IOException e) {}
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(ts);

			HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();
			messageSender.setKeyManagers(keyManagerFactory.getKeyManagers());
			messageSender.setTrustManagers(trustManagerFactory.getTrustManagers());

			// otherwise: java.security.cert.CertificateException: No name
			// matching localhost found
			messageSender.setHostnameVerifier((hostname, sslSession) -> {
				if (hostname.equals("localhost")) {
					return true;
				}
				return false;
			});

			client.setMessageSender(messageSender);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return client;
	}
}
