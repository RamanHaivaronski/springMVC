package com.babich.controllers;

import com.babich.models.User;
import com.babich.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    UserService service;


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
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) throws Exception {
        service.addUser(user);
        return "redirect:/";
    }
}
