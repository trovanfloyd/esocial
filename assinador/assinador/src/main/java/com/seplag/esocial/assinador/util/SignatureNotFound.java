package com.seplag.esocial.assinador.util;

public class SignatureNotFound extends RuntimeException {

    public SignatureNotFound() {
        super("Cannot find Signature element.");
    }
}
