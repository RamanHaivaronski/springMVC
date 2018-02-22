package com.babich.controllers;

import com.babich.models.User;
import com.babich.services.CarService;
import com.babich.services.SecurityService;
import com.babich.services.UserService;
import com.babich.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    UserValidator userValidator;

    @Autowired
    SecurityService securityService;

    @Autowired
    CarService carService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/";

    }

    @GetMapping("/carsView/{id}")
    public String cars(){
        return "cars";
    }

    //@PostMapping("/addUser")
    //public String addUser(@ModelAttribute("user") User user) throws Exception {
     //   service.addUser(user);
   //     return "redirect:/";
 //   }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        service.addUser(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getPassword());
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }


    // post login ?????
    // added
    @RequestMapping(value = "/addCar/", method = RequestMethod.POST)
    public String addCar(@RequestParam int user_id, @RequestParam int car_id) {

        carService.addCar(user_id,car_id);
        return "success";
    }
    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    public String deleteCar(@RequestParam int user_id, int car_id) {

        carService.deleteCar(user_id,car_id);
        return "success";
    }

}
