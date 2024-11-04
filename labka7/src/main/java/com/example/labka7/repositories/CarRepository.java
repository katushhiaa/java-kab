package com.example.labka7.repositories;

import com.example.labka7.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Car car) {
        String sql = "INSERT INTO car (marka, model, year, fuel_type, body_type, color, license_plate, passenger_capacity, load_capacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getMarka(), car.getModel(), car.getYear(), car.getFuelType(), car.getBodyType(), car.getColor(), car.getLicensePlate(), car.getPassengerCapacity(), car.getLoadCapacity());
    }

    public List<Car> findAll() {
        String sql = "SELECT * FROM car";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Car car = new Car();
            car.setId(rs.getInt("id"));
            car.setMarka(rs.getString("marka"));
            car.setModel(rs.getString("model"));
            car.setYear(rs.getInt("year"));
            car.setFuelType(rs.getString("fuel_type"));
            car.setBodyType(rs.getString("body_type"));
            car.setColor(rs.getString("color"));
            car.setLicensePlate(rs.getString("license_plate"));
            car.setPassengerCapacity(rs.getInt("passenger_capacity"));
            car.setLoadCapacity(rs.getDouble("load_capacity"));
            return car;
        });
    }

    public void update(int id, String color) {
        String sql = "UPDATE car SET color = ? WHERE id = ?";
        jdbcTemplate.update(sql, color, id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM car WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}


