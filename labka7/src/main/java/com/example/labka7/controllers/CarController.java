package com.example.labka7.controllers;
import com.example.labka7.models.Car;
import com.example.labka7.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    @Autowired
    private CarServices carService;

    @GetMapping("/car-form")
    public String showCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "car-form";
    }

    @PostMapping("/add-car")
    public String addCar(Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String listCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car-list";
    }

    @PostMapping("/update-car")
    public String updateCar(@RequestParam("id") int id, @RequestParam("color") String color) {
        carService.updateCarColor(id, color);
        return "redirect:/cars";
    }

    @PostMapping("/delete-car")
    public String deleteCar(@RequestParam("id") int id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}

