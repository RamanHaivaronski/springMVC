package com.babich.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private int user_id;
    private String name;
    private String surname;
    private String login;
    @JsonIgnore
    private String password;

    public User() {
    }

    public User(int user_id, String name, String surname, String login, String password) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}