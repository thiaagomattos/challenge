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
        return "Retorno da api";
    }

    @PostMapping("/post")
    public Car post(@RequestBody Car car) {
        return carService.save(car);
    }

    @PostMapping("/post2/{id}")
    public String post(@PathVariable String id) {
        return id;
    }
}
