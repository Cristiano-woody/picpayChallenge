package com.cristiano.picpayChallenge.implementation.Services.protocols;

import com.cristiano.picpayChallenge.domain.entities.User;

public interface NotificationSender {
    void send(User user, String message);
}
