package com.schroh.springboot.error.springboot_error;

import com.schroh.springboot.error.springboot_error.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    List<User> UserServiceImpl() {
        List<User> users = new ArrayList<>();

        users.add(new User(1L,"Schroh","Santi"));
        users.add(new User(2L,"Gonzales","Jorge"));
        users.add(new User(3L,"Pereyra","Betiana"));
        users.add(new User(4L,"Schroeder","Sol"));

        return users;
    }

}
