package com.cristiano.picpayChallenge.domain.exceptions;

public class EmailAlreadyRegistered extends RuntimeException {
    public EmailAlreadyRegistered() {
        super("Esse email já está cadastrado no sistema.");
    }
}
