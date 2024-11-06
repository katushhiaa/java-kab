package com.example.labka7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "client",
        uniqueConstraints = @UniqueConstraint(columnNames = {"phoneNumber"}),
        indexes = @Index(columnList = "phoneNumber")
)
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "hashed_password", nullable = false)
    private String hashedPassword;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;
}
