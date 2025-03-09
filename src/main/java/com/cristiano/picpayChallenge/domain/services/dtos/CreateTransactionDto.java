package com.cristiano.picpayChallenge.domain.services.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionDto(
        BigDecimal value,
        UUID senderId,
        UUID receiverId
) {
}
