package com.example.car.service;

import com.example.car.dtos.CarDtoRequest;
import com.example.car.dtos.CarDtoResponse;
import com.example.car.entity.Car;
import com.example.car.exception.CarIncorrectFieldException;
import com.example.car.exception.CarIncorrectBrandException;
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
            throw new CarIncorrectBrandException("Incorrect brand!");
        };

        if(carDtoRequest.getName() == null || carDtoRequest.getColor() == null || carDtoRequest.getFabricationYear() == null) {
            throw new NullPointerException("Error: null field!");
        }

        if(carDtoRequest.getName().length() < 1 || carDtoRequest.getColor().length() < 1 || carDtoRequest.getFabricationYear().length() < 1) {
            throw new CarIncorrectFieldException("Insert a valid name, color and fabrication year!");
        }

        Car car = new Car(null, carDtoRequest.getName(), carDtoRequest.getBrand(),
                carDtoRequest.getColor(), carDtoRequest.getFabricationYear());

        return carRepository.save(car);

    }

    public CarDtoResponse getById(Long id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new CarIncorrectBrandException("Car not found"));
        CarDtoResponse carDtoResponse = new CarDtoResponse(car.getIdChassi(), car.getName(),
                car.getBrand(), car.getColor(), car.getFabricationYear());
        return carDtoResponse;
    }


}
