package com.schroh.springboot.error.springboot_error.models.domain;

import org.springframework.stereotype.Component;

@Component
public class Role {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
