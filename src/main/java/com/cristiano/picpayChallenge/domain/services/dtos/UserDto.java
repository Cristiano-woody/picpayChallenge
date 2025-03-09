package com.cristiano.picpayChallenge.domain.services.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record UserDto(
        UUID id,
        String firstName,
        String lastName,
        String document,
        String email,
        BigDecimal balance
) {
}
