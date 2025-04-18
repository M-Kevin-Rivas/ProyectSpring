package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RedirectController {

    @GetMapping({"/","/redirect/listU"})
    public String getReturnListUsers() {
        return "redirect:/userList"; //Redirecciona a la ruta /userList
        //hace una nueva peticion y se pierde los parametros de la URL
    }
    
    @GetMapping({"/home","/forward/details"})
    public String getReturnDetails() {
        return "forward:/details"; //Redirecciona a la ruta /details, pero no cambia la URL en el navegador, es decir, no se redirecciona a otra vista, sino que se queda en la misma URL y carga la vista de details. Esto es útil cuando se quiere mantener la misma URL y cargar una vista diferente sin cambiar la URL en el navegador.
        //Lo que hace es abrir la vista detail pero en segundo plano sin perder los parametros
    }
}
