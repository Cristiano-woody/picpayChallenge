package com.cristiano.picpayChallenge.domain.services.dtos;

import com.cristiano.picpayChallenge.domain.entities.UserType;

import java.math.BigDecimal;

public record CreateUserRequestDto(
        String firstName,
        String lastName,
        String document,
        String email,
        BigDecimal balance,
        UserType userType,
        String password
) {
}
