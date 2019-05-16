package br.gov.ce.seplag.esocial.assinador.util;

import static java.util.Collections.singletonList;
import static javax.xml.crypto.dsig.CanonicalizationMethod.INCLUSIVE;
import static javax.xml.crypto.dsig.Transform.ENVELOPED;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.ArrayList;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlSigner extends DomValidationOperator {

	private static final String Entire_Document = "";
	private final PrivateKeyProvider provider;

	public XmlSigner(PrivateKeyData keyData) throws IOException, NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException, CertificateException {
		provider = new Pkcs12KeyProvider(factory, keyData);
	}

	public Document sign(Document document) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, IOException, UnrecoverableEntryException,
	        CertificateException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException {
		SignedInfo signedInfo = createSignature();
		KeyInfo keyInfo = provider.loadKeyInfo();
		PrivateKey privateKey = provider.loadPrivateKey();
		sign(document, privateKey, signedInfo, keyInfo);
		return document;
	}

	private void sign(Document document, PrivateKey privateKey, SignedInfo signedInfo, KeyInfo keyInfo) throws MarshalException, XMLSignatureException {
		DOMSignContext signContext = new DOMSignContext(privateKey, document.getDocumentElement());
		XMLSignature signature = factory.newXMLSignature(signedInfo, keyInfo);
		signature.sign(signContext);
	}

	private SignedInfo createSignature() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		// DigestMethod digestMethod =
		// factory.newDigestMethod(DigestMethod.SHA1, null);
		DigestMethod digestMethod = factory.newDigestMethod(DigestMethod.SHA256, null);

		Transform transform = factory.newTransform(ENVELOPED, (TransformParameterSpec) null);
		Transform exc14nTransform = factory.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null);
		ArrayList<Transform> transformList = new ArrayList<>();
		transformList.add(transform);
		transformList.add(exc14nTransform);

		// Reference reference = factory.newReference(Entire_Document,
		// digestMethod, singletonList(transform), null, null);
		Reference reference = factory.newReference(Entire_Document, digestMethod, transformList, null, null);

		// SignatureMethod signatureMethod =
		// factory.newSignatureMethod(RSA_SHA1, null);
		SignatureMethod signatureMethod = factory.newSignatureMethod("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256", null);
		CanonicalizationMethod canonicalizationMethod = factory.newCanonicalizationMethod(INCLUSIVE, (C14NMethodParameterSpec) null);
		return factory.newSignedInfo(canonicalizationMethod, signatureMethod, singletonList(reference));
	}
}
