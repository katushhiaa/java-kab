package com.example.labka7.models;

public class Order {
    private int id;
    private double distance;
    private Car car;
    private Client client;

    public Order(double distance, Car car, Client client) {
        this.distance = distance;
        this.car = car;
        this.client = client;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Driver driver) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
