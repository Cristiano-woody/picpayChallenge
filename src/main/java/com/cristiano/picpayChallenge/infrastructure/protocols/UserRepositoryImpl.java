package com.cristiano.picpayChallenge.infrastructure.protocols;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.implementation.Services.protocols.UserRepository;
import com.cristiano.picpayChallenge.infrastructure.protocols.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;


    @Override
    public Optional<User> findUserByDocument(String document) {
        return this.userRepositoryJpa.findUserByDocument(document);
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return this.userRepositoryJpa.findUserById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return this.userRepositoryJpa.findUserByEmail(email);
    }

    @Override
    public void save(User user) {
        this.userRepositoryJpa.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepositoryJpa.findAll();
    }
}
