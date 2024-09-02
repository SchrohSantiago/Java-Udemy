package com.schroh.di.factura.springboot_difactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope   // Es como RequestScope pero con un Scope mas chico
//@JsonIgnoreProperties({"targetSource", "advisors"})  // Esta anotacion es para quitar los residuos del proxy

public class Client {
    @Value("${client.name}")
    private String name;

    @Value("${client.lastname}")
    private String lastName;

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
}
