package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.proyect.springboot.webapp.springboot_web.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/methodsPost")
public class MethodsAPIController {
//Metodo que recibe un objeto JSON y lo convierte a un objeto Java
    //Ejemplo de como usar el metodo POST para recibir un objeto JSON y convertirlo a un objeto Java
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        user.setName_user(user.getName_user().toUpperCase());
        return user;
        //para probarlo se puede usar la siguiente URL: http://localhost:8080/api/methodsPost/createUser
    }
    
}
