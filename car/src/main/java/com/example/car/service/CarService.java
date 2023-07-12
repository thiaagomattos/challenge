package com.example.car.service;

import com.example.car.dtos.CarDtoRequest;
import com.example.car.dtos.CarDtoResponse;
import com.example.car.entity.Car;
import com.example.car.exception.CarNotFoundException;
import com.example.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public void save(CarDtoRequest carDtoRequest) {

        Car car = new Car(null, carDtoRequest.getName(), carDtoRequest.getBrand(),
                carDtoRequest.getColor(), carDtoRequest.getFabricationYear());

        carRepository.save(car);
    }

    public CarDtoResponse getById(Long id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new CarNotFoundException("Carro não encontrado"));
        CarDtoResponse carDtoResponse = new CarDtoResponse(car.getId(), car.getName(),
                car.getBrand(), car.getColor(), car.getFabricationYear());
        return carDtoResponse;
    }
}
