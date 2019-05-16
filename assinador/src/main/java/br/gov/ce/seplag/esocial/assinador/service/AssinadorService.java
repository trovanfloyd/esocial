package br.gov.ce.seplag.esocial.assinador.service;

import java.net.URL;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import br.gov.ce.seplag.esocial.assinador.to.AssinadorTO;
import br.gov.ce.seplag.esocial.assinador.util.PrivateKeyData;
import br.gov.ce.seplag.esocial.assinador.util.XmlSigner;

@Service
public class AssinadorService {

	private XmlSigner signer;

	public AssinadorTO sign(AssinadorTO assinadorDTO) {
		try {

			Document docSigned = sign(assinadorDTO.getDocument());
			assinadorDTO.setDocument(docSigned);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return assinadorDTO;
	}

	public Document signDoc(Document document) {
		Document docSigned = null;
		try {

			docSigned = sign(document);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return docSigned;
	}

	private Document sign(Document document) throws Exception {
		createSignerWithKeyData();
		return signer.sign(document);
	}

	public void createSignerWithKeyData() throws Exception {
		PrivateKeyData keyData = createKeyData();
		signer = new XmlSigner(keyData);
	}

	private PrivateKeyData createKeyData() {
		String pathToKeystore = getPathToFileOnClasspath("1000713905.pfx");
		String passphraseForKeystore = "cotec2018";
		String passphraseForKey = "cotec2018";
		return new PrivateKeyData(pathToKeystore, passphraseForKeystore, passphraseForKey);
	}

	private String getPathToFileOnClasspath(String name) {
		URL unsignedXmlUrl = getClass().getClassLoader().getResource(name);
		return unsignedXmlUrl.getFile();
	}

	public void verificarDocumentoPendentes() {
		// TODO Auto-generated method stub
		
	}

}
