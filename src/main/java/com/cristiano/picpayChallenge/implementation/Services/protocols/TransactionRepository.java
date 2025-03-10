package com.cristiano.picpayChallenge.implementation.Services.protocols;

import com.cristiano.picpayChallenge.domain.entities.Transaction;

public interface TransactionRepository {
    public void save(Transaction transaction);
}
