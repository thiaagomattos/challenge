package com.example.car.service;

import com.example.car.entity.Car;
import com.example.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    public String getString() {
        return "Dentro do service";
    }

    public Car save(Car car) {
        carRepository.save(car);
        return car;
    }

    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }
}
