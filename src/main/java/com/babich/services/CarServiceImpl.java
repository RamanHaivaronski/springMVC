package com.babich.services;

import com.babich.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void addCar(int user_id, int car_id) {
        userDAO.addCar(user_id, car_id);
    }
    @Override
    public void deleteCar(int user_id, int car_id){
        userDAO.deleteCar(user_id, car_id);
    }
}
