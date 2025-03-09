package com.cristiano.picpayChallenge.domain.exceptions;

public class TransactionRefusedException extends RuntimeException {
    public TransactionRefusedException() {
        super("Transaćão recusada.");
    }
}
