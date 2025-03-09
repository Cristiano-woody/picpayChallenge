package com.cristiano.picpayChallenge.domain.exceptions;

public class DocumentAlreadyRegistered extends RuntimeException {
    public DocumentAlreadyRegistered() {
        super("Esse CPF já está cadastrado no sistema");
    }
}
