package com.cristiano.picpayChallenge.infrastructure.protocols;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.implementation.Services.protocols.AuthorizeTransaction;
import com.cristiano.picpayChallenge.infrastructure.protocols.dtos.AuthorizeTransactionProtocolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class AuthorizeTransactionImpl implements AuthorizeTransaction {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public boolean isAuthorized(User sender, BigDecimal value, User receiver) {
        ResponseEntity<AuthorizeTransactionProtocolDto> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", AuthorizeTransactionProtocolDto.class);

        return authorizationResponse.getStatusCode() == HttpStatus.OK &&
                authorizationResponse.getBody() != null &&
                authorizationResponse.getBody().data != null &&
                authorizationResponse.getBody().data.authorization != null &&
                authorizationResponse.getBody().data.authorization;
    }
}
