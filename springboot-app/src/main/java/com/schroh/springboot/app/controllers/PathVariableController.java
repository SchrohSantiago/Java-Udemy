package com.schroh.springboot.app.controllers;

import com.schroh.springboot.app.models.User;
import com.schroh.springboot.app.models.dto.ParamDto;
import com.schroh.springboot.app.models.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Utilizamos el lenguaje de expresion de Spring
    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.listOfValues}'.split(',')}") // eL HASHTAG # Representa un lenguaje de expresiones de Spring
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.replaceAll(',',' ')}") // eL HASHTAG # Representa un lenguaje de expresiones de Spring
    private String valueString;

    @Value("#{${config.valuesMap}}") // Tomamos el Map creado en values.property y con la anotacion value inyectamos de manera gloabl este map
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Autowired
    private Environment enviroment; // Environment al igual que Value toma los valores de properties

    @GetMapping("/baz/{message}") // El parametro es variable
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}") // Obtenemos varios parametros de la ruta
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();
        json.put("product",product);
        json.put("id",id);

        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        // debemos guardar al usuario
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("message2", enviroment.getProperty("config.message")); //Enviroment nos permite obtener valores o datos de las properties
        json.put("code2", enviroment.getProperty("config.code", Long.class));
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        json.put("valueString", valueString);
        json.put("code", code);

        return json;
    }
}
