package com.example.labka7.otherservices;

import com.example.labka7.models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class carsByDistance {

    public static List<Car> carsByDistance(Connection connection) throws SQLException {
        List<Car> cars = new ArrayList<>();

        String sql = "SELECT car.*, SUM(o.distance) AS total_distance " +
                "FROM `orders` o " +
                "JOIN car ON o.car_id = car.id " +
                "GROUP BY car.id " +
                "ORDER BY total_distance ASC";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getString("marka"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getString("fuel_type"),
                        resultSet.getString("body_type"),
                        resultSet.getString("color"),
                        resultSet.getString("license_plate"),
                        resultSet.getInt("passenger_capacity"),
                        resultSet.getDouble("load_capacity")
                );
                car.setId(resultSet.getInt("id"));
                double totalDistance = resultSet.getDouble("total_distance");

                System.out.println("Автомобіль: " + car.getMarka() + " " + car.getModel() + " - Загальна дистанція: " + totalDistance + " км");

                cars.add(car);
            }
        }
        return cars;
    }
}
