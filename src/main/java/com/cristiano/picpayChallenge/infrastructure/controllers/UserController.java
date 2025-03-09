package com.cristiano.picpayChallenge.infrastructure.controllers;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.domain.services.UserService;
import com.cristiano.picpayChallenge.domain.services.dtos.CreateUserRequestDto;
import com.cristiano.picpayChallenge.domain.services.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(CreateUserRequestDto createUserRequest) {
        UserDto createUserResponse = this.userService.createUser(createUserRequest);
        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> AllUsersResponse = this.userService.findAllUsers();
        return new ResponseEntity<>(AllUsersResponse, HttpStatus.OK);
    }

}
