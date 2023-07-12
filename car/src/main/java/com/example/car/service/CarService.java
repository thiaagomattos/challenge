package com.example.car.service;

import com.example.car.dtos.CarDtoRequest;
import com.example.car.dtos.CarDtoResponse;
import com.example.car.entity.Car;
import com.example.car.exception.CarNotFoundException;
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

    public void save(CarDtoRequest carDtoRequest) {

        Car car = new Car(carDtoRequest.getIdChassi(), carDtoRequest.getName(), carDtoRequest.getBrand(), carDtoRequest.getColor(), carDtoRequest.getFabricationYear());
        carRepository.save(car);
    }

    public CarDtoResponse getById(Long idChassi) {
        Car car = carRepository.findById(idChassi).orElseThrow(() -> new CarNotFoundException("Carro não encontrado"));

        CarDtoResponse carDtoResponse = new CarDtoResponse(car.getIdChassi(), car.getName(), car.getBrand());
        return carDtoResponse;

    }
}
