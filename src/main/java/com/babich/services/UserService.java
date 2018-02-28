package com.babich.services;

import com.babich.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void delete(int id);
    void addUser(User user);
    User findByLogin(String login);
    public String getUsername();
}
