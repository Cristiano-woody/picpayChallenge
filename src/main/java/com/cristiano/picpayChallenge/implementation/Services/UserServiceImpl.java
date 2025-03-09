package com.cristiano.picpayChallenge.implementation.Services;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.domain.exceptions.DocumentAlreadyRegistered;
import com.cristiano.picpayChallenge.domain.exceptions.EmailAlreadyRegistered;
import com.cristiano.picpayChallenge.domain.exceptions.ResourceNotFound;
import com.cristiano.picpayChallenge.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(UUID id) {
        return this.userRepository.findUserById(id).orElseThrow(() -> new ResourceNotFound("Usuário: " + id + " não encontrado."));
    }

    public void saveUser(User user) {
        this.userRepository.findUserByDocument(user.getDocument()).ifPresent(u -> {
            throw new DocumentAlreadyRegistered();
        });

        this.userRepository.findUserByEmail(user.getEmail()).ifPresent(u -> {
            throw new EmailAlreadyRegistered();
        });

        this.userRepository.save(user);
    }
}
