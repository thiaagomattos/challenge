package com.example.car.service;

import com.example.car.dtos.CarDtoRequest;
import com.example.car.dtos.CarDtoResponse;
import com.example.car.entity.Car;
import com.example.car.exception.CarNotFoundException;
import com.example.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class CarService {

    String[] marcas = {"BMW", "Ford", "Volvo", "Chevrolet"};

    @Autowired
    CarRepository carRepository;

    public Car save(CarDtoRequest carDtoRequest) {

        if(!Arrays.asList(marcas).contains(carDtoRequest.getBrand())){
            throw new CarNotFoundException("Car NOT saved");
        };

        if(carDtoRequest.getName() == null || carDtoRequest.getColor() == null || carDtoRequest.getFabricationYear() == null) {
            throw new CarNotFoundException("Error: null field");
        }

        Car car = new Car(null, carDtoRequest.getName(), carDtoRequest.getBrand(),
                carDtoRequest.getColor(), carDtoRequest.getFabricationYear());

        return carRepository.save(car);

    }

    public CarDtoResponse getById(Long id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found"));
        CarDtoResponse carDtoResponse = new CarDtoResponse(car.getIdChassi(), car.getName(),
                car.getBrand(), car.getColor(), car.getFabricationYear());
        return carDtoResponse;
    }


}
