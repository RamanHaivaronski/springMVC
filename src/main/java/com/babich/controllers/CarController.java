package com.babich.controllers;

import com.babich.models.Car;
import com.babich.services.CarService;
import com.babich.services.SecurityService;
import com.babich.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping("/carsView/{id}")
    public String cars(){
        return "cars";
    }


    @GetMapping("/control_of_cars")
    public String control_of_cars(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "control_of_cars";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("carForm")Car carForm) {

        carService.addCar(carForm);
        return "redirect:/control_of_cars";
    }
    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    public String deleteCar(@RequestParam int car_id) {

        carService.deleteCar(car_id);
        return "redirect:/control_of_cars";
    }
}
