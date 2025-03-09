package com.cristiano.picpayChallenge.implementation.Services.protocols;

import com.cristiano.picpayChallenge.domain.entities.User;

import java.math.BigDecimal;

public interface AuthorizeTransaction {
    boolean isAuthorized(User sender, BigDecimal value, User receiver);
}
