package com.babich.services;

import com.babich.dao.CarDAO;
import com.babich.dao.UserDAO;
import com.babich.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    @Autowired
    CarDAO carDAO;

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }
    @Override
    public void addCar(Car car) {
        carDAO.addCar(car);
    }
    @Override
    public void deleteCar(int car_id){
        carDAO.deleteCar(car_id);
    }
}
