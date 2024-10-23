package org.example;

import java.util.Date;


public class Driver {
    private int id;
    private String fullName;
    private String birthDate;
    private int drivingExperience;
    private String phoneNumber;
    private Car car;

    public Driver(String fullName, String birthDate, int drivingExperience, String phoneNumber, Car car) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.drivingExperience = drivingExperience;
        this.phoneNumber = phoneNumber;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
