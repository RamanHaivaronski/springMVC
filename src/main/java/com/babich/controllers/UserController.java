package com.babich.controllers;

import com.babich.models.User;
import com.babich.services.SecurityService;
import com.babich.services.UserService;
import com.babich.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    UserValidator userValidator;

    @Autowired
    SecurityService securityService;

    @GetMapping("/usersAll")
    @ResponseBody
    public List<User> index() {
        return service.getAllUsers();

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        service.delete(id);
    }

    @GetMapping("/registration")
    public String registrati4on(Model model) {
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
        System.out.println(service.getUsername());
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

}
