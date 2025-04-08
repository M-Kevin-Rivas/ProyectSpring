package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserRestController {

    @GetMapping("/details2") //El nombre de la ruta es /details en el navegador
    public Map<String,Object> details(){
        Map<String, Object> bodyResponse = new HashMap<>(); //Se crea un mapa para almacenar los datos que se van a enviar al cliente
        bodyResponse.put("tittle","Iniciando en SprinBoot");
        bodyResponse.put("name", "Kevin Rivas");
        bodyResponse.put("sex", "Male");
        bodyResponse.put("age", "30 years old");

        return bodyResponse;
    }

}
