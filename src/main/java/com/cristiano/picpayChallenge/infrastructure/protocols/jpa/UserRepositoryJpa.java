package com.cristiano.picpayChallenge.infrastructure.protocols.jpa;

import com.cristiano.picpayChallenge.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryJpa extends JpaRepository<User, UUID> {

    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(UUID id);

    Optional<User> findUserByEmail(String email);
}
