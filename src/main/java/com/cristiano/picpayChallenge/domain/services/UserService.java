package com.cristiano.picpayChallenge.domain.services;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.domain.services.dtos.CreateUserRequestDto;
import com.cristiano.picpayChallenge.domain.services.dtos.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public User findUserById(UUID id);

    public User findUserByDocument(String document);

    public User findUserByEmail(String email);

    public void saveUser(User user);

    public UserDto createUser(CreateUserRequestDto user);

    public List<UserDto> findAllUsers();
}
