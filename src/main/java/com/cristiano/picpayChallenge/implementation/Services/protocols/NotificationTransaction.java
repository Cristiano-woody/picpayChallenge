package com.cristiano.picpayChallenge.implementation.Services.protocols;

import com.cristiano.picpayChallenge.domain.entities.User;

import java.math.BigDecimal;

public interface NotificationTransaction {
    public void notify(User sender, User receiver, BigDecimal value);
}
