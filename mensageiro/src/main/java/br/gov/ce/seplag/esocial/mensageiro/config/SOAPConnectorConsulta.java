package br.gov.ce.seplag.esocial.mensageiro.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SOAPConnectorConsulta extends WebServiceGatewaySupport {

	public Object callWebService(String url, Object request) {
//		return getWebServiceTemplate().marshalSendAndReceive(request, new WebServiceMessageCallback() {
//		        public void doWithMessage(WebServiceMessage message) {
//		        	System.out.println("a");
//		            ((SoapMessage)message).setSoapAction(url);
//		        }
//		    });
//		
		return getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(url));
		
	}
}
