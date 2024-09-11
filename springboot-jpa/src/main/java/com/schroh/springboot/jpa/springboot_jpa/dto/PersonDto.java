package com.schroh.springboot.jpa.springboot_jpa.dto;


public class PersonDto {

    private String name;
    private String lastName;

    public PersonDto(String name, String lastName) {
        this.lastName = lastName;
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
