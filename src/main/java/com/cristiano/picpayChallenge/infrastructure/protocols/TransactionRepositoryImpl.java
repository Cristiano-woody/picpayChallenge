package com.cristiano.picpayChallenge.infrastructure.protocols;

import com.cristiano.picpayChallenge.domain.entities.Transaction;
import com.cristiano.picpayChallenge.implementation.Services.protocols.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void save(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }
}
