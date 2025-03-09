package com.cristiano.picpayChallenge.domain.services;

import com.cristiano.picpayChallenge.domain.entities.User;

import java.math.BigDecimal;

public interface TransactionService {
    public void validateTransaction(User sender, BigDecimal amount);
}
