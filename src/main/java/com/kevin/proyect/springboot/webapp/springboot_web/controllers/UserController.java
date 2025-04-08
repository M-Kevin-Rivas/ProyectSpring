package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {

    @GetMapping("/details") //El nombre de la ruta es /details en el navegador
    public String details(Model model){
        model.addAttribute("tittle","Inciando en SprinBoot");
        model.addAttribute("nameOwner", "Kevin Rivas");
        model.addAttribute("description", "Este es un proyecto de prueba para aprender Spring Boot y Thymeleaf");

        return "details"; //Es una vista(HTML) que se encuentra en la carpeta templates y debe llamarse con su nombre sin la extension
    }

}
