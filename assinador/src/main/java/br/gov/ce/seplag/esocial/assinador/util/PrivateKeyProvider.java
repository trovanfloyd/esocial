package br.gov.ce.seplag.esocial.assinador.util;

import java.security.PrivateKey;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;

public interface PrivateKeyProvider {

    KeyInfo loadKeyInfo();

    PrivateKey loadPrivateKey();
}
