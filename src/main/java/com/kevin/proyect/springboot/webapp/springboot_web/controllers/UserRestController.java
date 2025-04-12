package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        userDto.setYoungerThan25(otherUser.getAge_user() <= 25); //El DTO es para agregar/quitar o editar información al objeto que se quiere mandar en el REST
        return userDto; 
    } 
    @GetMapping("/userList")
    public List<User> list(){

        User user1 = new User("1","Kevin Rivas", 30, "kevinRivas64@patito.com");
        User user2 = new User("1","Alejando Arias", 32, "aleComArias27@patito.com");
        User user3 = new User("1","Julio Arispe", 28, "julioArsp46@patito.com");
        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3)); //Se crea una lista de usuarios con el método of() de la clase List
        return users;
    }

}
