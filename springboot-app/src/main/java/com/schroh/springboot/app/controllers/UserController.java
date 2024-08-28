package com.schroh.springboot.app.controllers;

import com.schroh.springboot.app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) { // Model de Spring Boot es como si fuese un map
        User user = new User("Santiago","Schroh");
        user.setEmail("santiago@gmail.com");
        model.addAttribute("title", "Hola mundo Spring");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }

    @ModelAttribute("users") // Globalmente asigna para el tymeleaft
    public List<User> userModel(){
        List<User> users = Arrays.asList(new User("Gonzales","Jorge"),
                new User("Estevanez", "Rodrigo", "rodri@gmail.com"),
                new User("Garcia","Rolando"));

        return users;
    }
}
