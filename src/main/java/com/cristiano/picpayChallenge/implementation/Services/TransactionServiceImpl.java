package com.cristiano.picpayChallenge.implementation.Services;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.domain.entities.UserType;
import com.cristiano.picpayChallenge.domain.exceptions.InsufficientBalanceException;
import com.cristiano.picpayChallenge.domain.exceptions.MerchantTransactionException;
import com.cristiano.picpayChallenge.domain.services.TransactionService;

import java.math.BigDecimal;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public void validateTransaction(User sender, BigDecimal amount) {
        if(sender.getUserType().equals(UserType.MERCHANT)) {
            throw new MerchantTransactionException();
        }

        if(sender.getBalance().compareTo(amount) < 0) {
        throw new InsufficientBalanceException();
        }


    }
}
