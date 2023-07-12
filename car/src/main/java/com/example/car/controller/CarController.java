package com.example.car.controller;

import com.example.car.dtos.CarDtoRequest;
import com.example.car.dtos.CarDtoResponse;
import com.example.car.entity.Car;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/post")
    public String post(@RequestBody CarDtoRequest carDtoRequest) {
        carService.save(carDtoRequest);
        return "Salvo com sucesso!";
    }

    @GetMapping("/get/{id}")
    public CarDtoResponse post(@PathVariable Long id) {
        return carService.getById(id);
    }
}
