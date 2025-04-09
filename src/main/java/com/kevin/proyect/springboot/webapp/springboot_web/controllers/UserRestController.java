package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.proyect.springboot.webapp.springboot_web.models.User;
import com.kevin.proyect.springboot.webapp.springboot_web.models.dto.UserDto;



@RestController
@RequestMapping("/api") //El nombre de la ruta es /api en el navegador
public class UserRestController {

    @GetMapping("/detailsMap") //El nombre de la ruta es /details en el navegador
    public Map<String,Object> detailsMap(){
        User userObject = new User("1","Kevin Rivas", 30, "kevinRivas64@patito.com");
        Map<String, Object> bodyResponse = new HashMap<>(); //Se crea un mapa para almacenar los datos que se van a enviar al cliente
        bodyResponse.put("tittle","Iniciando en SpringBoot");
        bodyResponse.put("user", userObject);
        
        return bodyResponse;
    }

    @GetMapping("/detailsDTO")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User otherUser = new User("1","Kevin Rivas", 30, "kevinRivas64@patito.com");
        userDto.setTitle("Iniciando en SpringBoot");
        userDto.setUserDto(otherUser);

        return userDto; 
    } 

}
