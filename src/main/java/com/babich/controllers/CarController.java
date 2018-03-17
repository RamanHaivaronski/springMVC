package com.babich.controllers;

import com.babich.models.Car;
import com.babich.services.CarService;
import com.babich.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;


    @GetMapping("/carsView")
    public List<Car> getMyCar() {
        return carService.getUserCars();
    }


    @GetMapping("/control_of_cars")
    public List<Car> control_of_cars() {
        return carService.getAllCars();

    }

    @GetMapping("/deleteUserCars/{car_id}")
    public String deleteUserCars(@PathVariable("car_id") int car_id) {
        carService.deleteUserCar(car_id);


        return "redirect:/carsView";
    }

    //by admin
    @PostMapping("/addCar")
    public void addCar(@ModelAttribute("carForm") Car carForm) {
        carService.addCar(carForm);
    }

}
