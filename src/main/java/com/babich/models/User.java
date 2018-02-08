package com.babich.models;

public class User {
    private int user_id;
    private String name;
    private String surname;

    public User() {
    }


    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(int user_id, String name, String surname) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
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


}