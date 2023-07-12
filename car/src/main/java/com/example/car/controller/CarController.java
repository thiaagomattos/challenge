package com.example.car.controller;

import com.example.car.entity.Car;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CarController {

    @Autowired
    CarService carService;
    @GetMapping("/get")
    public String get() {
        return carService.getString();
    }

    @PostMapping("/post")
    public Car post(@RequestBody Car car) {
        return carService.save(car);
    }

    @GetMapping("/get/{id}")
    public Car post(@PathVariable Long id) {
        return carService.getById(id);
    }
}
