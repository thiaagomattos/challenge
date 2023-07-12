package com.example.car.dtos;

public class CarDtoResponse {
    private Long idChassi;
    private String name;
    private String brand;

    public CarDtoResponse(Long idChassi, String name, String brand) {
        this.idChassi = idChassi;
        this.name = name;
        this.brand = brand;
    }

    public Long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(Long idChassi) {
        this.idChassi = idChassi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

