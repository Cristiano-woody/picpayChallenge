package com.cristiano.picpayChallenge.domain.entities;

import com.cristiano.picpayChallenge.domain.services.dtos.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    @Column
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public UserDto toDto() {
        return new UserDto(id, firstName, lastName, document, email, balance);
    }
}
