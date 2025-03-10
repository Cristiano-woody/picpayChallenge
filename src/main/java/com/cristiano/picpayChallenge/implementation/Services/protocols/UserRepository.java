package com.cristiano.picpayChallenge.implementation.Services.protocols;

import com.cristiano.picpayChallenge.domain.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(UUID id);

    Optional<User> findUserByEmail(String email);

    void save(User user);

    List<User> findAll();
}
