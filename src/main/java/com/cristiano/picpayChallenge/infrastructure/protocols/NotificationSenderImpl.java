package com.cristiano.picpayChallenge.infrastructure.protocols;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.implementation.Services.protocols.NotificationSender;
import com.cristiano.picpayChallenge.infrastructure.protocols.dtos.NotificationSenderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationSenderImpl implements NotificationSender {

    @Autowired
    private RestTemplate restTemplate;

    private final String urlRequest = "http://o4d9z.mocklab.io/notify";

    @Override
    public void send(User user, String message) {
        NotificationSenderDto notificationRequestSender = new NotificationSenderDto(user.getEmail(), message);

        // nao achei nem um mock para servico de email e a url fornecida desta fora do ar
        ResponseEntity<String> response = restTemplate.postForEntity(urlRequest, notificationRequestSender, String.class);
    }
}
