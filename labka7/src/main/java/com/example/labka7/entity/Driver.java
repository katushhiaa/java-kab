package com.example.labka7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "driver",
        uniqueConstraints = @UniqueConstraint(columnNames = {"licenseNumber"}),
        indexes = @Index(columnList = "licenseNumber")
)
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;

    @Column(name = "experience_years", nullable = false)
    private int experienceYears;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
}
