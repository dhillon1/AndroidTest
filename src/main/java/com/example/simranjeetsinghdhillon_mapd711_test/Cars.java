package com.example.simranjeetsinghdhillon_mapd711_test;

public class Cars {

    private int carId;
    private String brandName;
    private String model;
    private int year;
    private double price;

    public Cars(){}

    public Cars(int carId, String brandName, String model, int year, double price){
        this.carId = carId;
        this.brandName = brandName;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getCarId() {
        return carId;
    }

    public int getYear() {
        return year;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModel() {
        return model;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
