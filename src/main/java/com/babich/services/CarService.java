package com.babich.services;

import com.babich.models.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    void addCar(Car car);

    void deleteCar(int car_id);
}
