package com.cristiano.picpayChallenge.domain.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("O usuário não possui saldo suficiente para fazer essa transaćão.");
    }
}
