package com.example.car.dtos;

public class CarDtoResponse {
    private Long idChassi;
    private String name;
    private String brand;
    private String color;
    private String fabricationYear;

    public CarDtoResponse(Long id, String name, String brand, String color, String fabricationYear) {
        this.idChassi = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public Long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(Long id) {
        this.idChassi = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }
}
