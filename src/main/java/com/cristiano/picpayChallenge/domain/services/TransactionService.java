package com.cristiano.picpayChallenge.domain.services;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.domain.services.dtos.CreateTransactionDto;

import java.math.BigDecimal;

public interface TransactionService {
    public void validateTransaction(User sender, BigDecimal value);

    public void createTransaction(CreateTransactionDto createTransactionDto);

    public void sendNotificationTransaction(User receiver,User sender , BigDecimal value);
}
