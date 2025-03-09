package com.cristiano.picpayChallenge.implementation.Services;

import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.domain.exceptions.DocumentAlreadyRegistered;
import com.cristiano.picpayChallenge.domain.exceptions.EmailAlreadyRegistered;
import com.cristiano.picpayChallenge.domain.exceptions.ResourceNotFound;
import com.cristiano.picpayChallenge.domain.services.UserService;
import com.cristiano.picpayChallenge.domain.services.dtos.CreateUserRequestDto;
import com.cristiano.picpayChallenge.domain.services.dtos.UserDto;
import com.cristiano.picpayChallenge.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(UUID id) {
        return this.userRepository.findUserById(id).orElseThrow(() -> new ResourceNotFound("Usuário: " + id + " não encontrado."));
    }

    public User findUserByDocument(String document) {
        return this.userRepository.findUserByDocument(document).orElseThrow(() -> new ResourceNotFound("Usuário: " + document + " não encontrado."));
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email).orElseThrow(() -> new ResourceNotFound("Usuário: " + email + " não encontrado."));
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public UserDto createUser(CreateUserRequestDto createUserDto) {
        this.userRepository.findUserByDocument(createUserDto.document()).ifPresent(u -> {
            throw new DocumentAlreadyRegistered();
        });

        this.userRepository.findUserByEmail(createUserDto.email()).ifPresent(u -> {
            throw new EmailAlreadyRegistered();
        });

        User newUser = new User();
        newUser.setFirstName(createUserDto.firstName());
        newUser.setLastName(createUserDto.lastName());
        newUser.setDocument(createUserDto.document());
        newUser.setEmail(createUserDto.email());
        newUser.setPassword(createUserDto.password());
        newUser.setUserType(createUserDto.userType());
        newUser.setBalance(createUserDto.balance());

        this.userRepository.save(newUser);

        return new UserDto(
                newUser.getId(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getDocument(),
                newUser.getEmail(),
                newUser.getBalance()
        );
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = this.userRepository.findAll();

        List<UserDto> listUserDto = new ArrayList<>();

        users.forEach(u -> {
            listUserDto.add(u.toDto());
        });

        return listUserDto;
    }
}
