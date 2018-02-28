package com.babich.services;

import com.babich.dao.CarDAO;
import com.babich.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    @Autowired
    CarDAO carDAO;

    @Autowired
    UserService userService;

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    @Override
    public void deleteCar(int car_id) {
        carDAO.deleteCar(car_id);
    }


    @Override
    public List<Car> getUserCars() {
        return carDAO.getMyCars(userService.findByLogin(userService.getUsername()).getUser_id());
    }

    @Override
    public List<Car> getNotUserCars() {
        return carDAO.getNotMyCars(userService.findByLogin(userService.getUsername()).getUser_id());
    }

    @Override
    public void deleteUserCar(int car_id) {
        System.out.println(userService.findByLogin(userService.getUsername()).getUser_id());
        System.out.println(car_id);
        carDAO.deleteUserCar(userService.findByLogin(userService.getUsername()).getUser_id(),car_id);
    }
}
