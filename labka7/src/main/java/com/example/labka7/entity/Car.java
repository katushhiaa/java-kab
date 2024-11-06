package com.example.labka7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "car",
        uniqueConstraints = @UniqueConstraint(columnNames = {"licensePlate"}),
        indexes = @Index(columnList = "licensePlate")
)
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "marka", nullable = false)
    private String marka;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

    @Column(name = "body_type", nullable = false)
    private String bodyType;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @Column(name = "passenger_capacity", nullable = false)
    private int passengerCapacity;

    @Column(name = "load_capacity", nullable = false)
    private double loadCapacity;
}
