package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kevin.proyect.springboot.webapp.springboot_web.models.User;



@Controller
public class UserController {

    @GetMapping("/details") //El nombre de la ruta es /details en el navegador
    public String details(Model model){
        User userK = new User("1","Kevin Rivas", 30, "kevinRivas64@patito.com");
        model.addAttribute("tittle","Iniciando en SprinBoot");
        model.addAttribute("userOwner", userK);
        //model.addAttribute("nameOwner", "Kevin Rivas"); //para que acceda desde el HTML se le pone el nombre del atributo que se le asigna en el controlador
        //model.addAttribute("description", "Este es un proyecto de prueba para aprender Spring Boot y Thymeleaf");

        return "details"; //Es una vista(HTML) que se encuentra en la carpeta templates y debe llamarse con su nombre sin la extension
    }

}
