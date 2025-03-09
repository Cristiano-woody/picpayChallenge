package com.cristiano.picpayChallenge.domain.exceptions;

public class MerchantTransactionException extends RuntimeException {
    public MerchantTransactionException() {
        super("Usuário do tipo lojista não está autorizado a fazer transaćões.");
    }
}
