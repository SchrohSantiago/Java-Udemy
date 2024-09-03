package com.schroh.springboot.error.springboot_error.models.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class User {

    private String name;
    private String lastName;
    private Long id;

    @Autowired
    private Role role;

    public User() {

    }

    public User(Long id, String lastName, String name) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
