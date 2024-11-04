package com.example.labka7.services;
import com.example.labka7.models.Car;
import com.example.labka7.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServices {
    @Autowired
    private CarRepository carRepository;

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void updateCarColor(int id, String color) {
        carRepository.update(id, color);
    }

    public void deleteCar(int id) {
        carRepository.delete(id);
    }
}
