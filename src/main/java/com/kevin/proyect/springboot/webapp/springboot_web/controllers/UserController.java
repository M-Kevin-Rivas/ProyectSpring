package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kevin.proyect.springboot.webapp.springboot_web.models.User;



@Controller
public class UserController {

    @GetMapping("/details") //El nombre de la ruta es /details en el navegador
    public String details(Model model){
        User userK = new User("1","Kevin Rivas", 30, "kevinRivas64@patito.com");
        //userK.setPassword_user("12345"); //Para probar que funciona el if del thymeleaf
        model.addAttribute("tittle","Iniciando en SpringBoot");
        model.addAttribute("userOwner", userK);
        //model.addAttribute("nameOwner", "Kevin Rivas"); //para que acceda desde el HTML se le pone el nombre del atributo que se le asigna en el controlador
        //model.addAttribute("description", "Este es un proyecto de prueba para aprender Spring Boot y Thymeleaf");

        return "details"; //Es una vista(HTML) que se encuentra en la carpeta templates y debe llamarse con su nombre sin la extension
    }

    @GetMapping("/userList") //El nombre de la ruta es /details en el navegador
    public String list(ModelMap model){
        //List<User> usersList = new ArrayList<>();
        model.addAttribute("tittle","Lista de Usuarios en Spring con Thymeleaf");
        // User user1 = new User("1","Kevin Rivas", 30, "kevinRivas64@patito.com");
        // User user2 = new User("2","Alejando Arias", 32, "aleComArias27@patito.com","12345");
        // User user3 = new User("3","Julio Arispe", 28, "julioArsp46@patito.com");
        // usersList.addAll(Arrays.asList(user1, user2, user3)); //Se crea una lista de usuarios con el método of() de la clase List
        // model.addAttribute("users",usersList);
        return "list";
    }
    @ModelAttribute("users")
    //Con esta notacion podemos crear un atributo que se puede usar en cualquier vista
    //El nombre del atributo es el que se le asigna en la anotacion
    //Es recomendable usarlo cuando existen datos que se requieran en varias vistas
    //En este caso se le asigna el nombre de users a la lista de usuarios    
    public List<User> listUsers(){
        User user1 = new User("1","Kevin Rivas", 30, "kevinRivas64@patito.com");
        User user2 = new User("2","Alejando Arias", 32, "aleComArias27@patito.com","12345");
        User user3 = new User("3","Julio Arispe", 28, "julioArsp46@patito.com");
        return Arrays.asList(user1, user2, user3); //Se crea una lista de usuarios con el método of() de la clase List
        

     

    }

}
