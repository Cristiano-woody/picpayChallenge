package com.cristiano.picpayChallenge.infrastructure.protocols;

import com.cristiano.picpayChallenge.domain.entities.Transaction;
import com.cristiano.picpayChallenge.implementation.Services.protocols.TransactionRepository;
import com.cristiano.picpayChallenge.infrastructure.protocols.jpa.TransactionRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private TransactionRepositoryJpa transactionRepository;

    @Override
    public void save(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }
}
