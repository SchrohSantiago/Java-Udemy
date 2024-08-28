package com.schroh.springboot.app.controllers;

import com.schroh.springboot.app.models.User;
import com.schroh.springboot.app.models.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController // Con rest lo que hacemos es devolver el contenido como un JSON
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() { // Model de Spring Boot es como si fuese un map

        User user = new User("Santiago","Schroh");
        UserDto userDto = new UserDto();

        userDto.setUser(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setTitle("Hola mundo Spring");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Santiago","Schroh");
        User user2 = new User("Carlos","Bonavitta");
        User user3 = new User("Agustin","Alvarez");

        List<User> users = Arrays.asList(user,user2,user3);

        return users;
    }

}
