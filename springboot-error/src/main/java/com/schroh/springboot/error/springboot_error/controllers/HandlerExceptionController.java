package com.schroh.springboot.error.springboot_error.controllers;


import com.schroh.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.schroh.springboot.error.springboot_error.models.Error;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero(Exception ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

//        return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Si o si
    public Map<String,Object> numberFormatException(Exception ex){ // Es otra forma de hacelo pero con el uso de un Map

        Map<String, Object> error = new HashMap<>();
        error.put("date",new Date());
        error.put("error","numero invalido o incorrecto, no posee formato de digito");
        error.put("message",ex.getMessage());
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Si o si
    public Map<String,Object> userNotFoundException(Exception ex){ // Es otra forma de hacelo pero con el uso de un Map

        Map<String, Object> error = new HashMap<>();
        error.put("date",new Date());
        error.put("error","el usuario o role no existe");
        error.put("message",ex.getMessage());
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> norFoundEx(NoHandlerFoundException e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error); // Ver el archivo properties, sin la modificacion en properties Spring por defecto no nos deja tirar el mensaje de error
    }
}
