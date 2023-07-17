package com.example.car.controller;

import com.example.car.dtos.CarDtoRequest;
import com.example.car.dtos.CarDtoResponse;
import com.example.car.exception.CarNotFoundException;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/post")
    public String post(@RequestBody CarDtoRequest carDtoRequest) {
        try {
            carService.save(carDtoRequest);
            return "Car saved!";
        } catch (CarNotFoundException e) {
            return "Car NOT saved, try again!";
        }
    }

    @GetMapping("/get/{id}")
    public CarDtoResponse post(@PathVariable Long id) {
        return carService.getById(id);
    }
}
