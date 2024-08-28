package com.schroh.springboot.app.models;

public class User {
    private String name;
    private String lastname;
    private String email;

    public User(){}
    public User(String lastname, String name, String email) {
        this(name, lastname);
        this.email = email;
    }

    public User(String lastname, String name) {
        this.lastname = lastname;
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
