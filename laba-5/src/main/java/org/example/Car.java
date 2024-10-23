package org.example;

public class Car {
    private int id;
    private String marka;
    private String model;
    private int year;
    private String fuelType;
    private String bodyType;
    private String color;
    private String licensePlate;
    private int passengerCapacity;
    private double loadCapacity;

    public Car(String marka, String model, int year, String fuelType, String bodyType, String color, String licensePlate, int passengerCapacity, double loadCapacity) {
        this.marka = marka;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
        this.color = color;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.loadCapacity = loadCapacity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
