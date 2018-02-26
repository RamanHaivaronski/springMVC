package com.babich.services;

import com.babich.dao.UserDAO;
import com.babich.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
        userDAO.setRoleById(user.getUser_id());
    }

    @Override
    public User findByLogin(String login) {
        return userDAO.findByLogin(login);
    }
}
