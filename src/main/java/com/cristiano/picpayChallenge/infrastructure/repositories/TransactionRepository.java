package com.cristiano.picpayChallenge.infrastructure.repositories;

import com.cristiano.picpayChallenge.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {


}
