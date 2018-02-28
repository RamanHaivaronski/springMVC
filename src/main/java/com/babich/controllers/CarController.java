package com.babich.controllers;

import com.babich.models.Car;
import com.babich.models.User;
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
    UserService userService;

    @Autowired
    CarService carService;


    @GetMapping("/carsView")
    public String cars(Model model){
        model.addAttribute("userCars",carService.getUserCars());
        model.addAttribute("notUserCars",carService.getNotUserCars());
        return "cars";
    }


    @GetMapping("/control_of_cars")
    public String control_of_cars(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "control_of_cars";
    }

    @GetMapping("/deleteUserCars/{car_id}")
    public String deleteUserCars(@PathVariable("car_id") int car_id){
        carService.deleteUserCar(car_id);


        return "redirect:/carsView";
    }

    //by admin
    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("carForm")Car carForm) {
        carService.addCar(carForm);
        return "redirect:/control_of_cars";
    }

}
