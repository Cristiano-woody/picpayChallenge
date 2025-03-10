package com.cristiano.picpayChallenge.infrastructure.protocols.jpa;

import com.cristiano.picpayChallenge.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepositoryJpa extends JpaRepository<Transaction, UUID> {


}
