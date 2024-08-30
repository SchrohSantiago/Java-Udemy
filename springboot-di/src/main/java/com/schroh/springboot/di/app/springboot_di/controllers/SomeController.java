package com.schroh.springboot.di.app.springboot_di.controllers;

import com.schroh.springboot.di.app.springboot_di.models.Product;
import com.schroh.springboot.di.app.springboot_di.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController { // El controlador es Singleton, es decir que es una unica instancia compartida en todo el programa

    @Autowired
    private ProductService service;  // Para realizar el codigo mas desacoplado tenemos que trabajar mediante la inyeccion de interfaces.

    @GetMapping
    public List<Product> list() {
      return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
      return service.findById(id);
    }
}
