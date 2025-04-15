package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kevin.proyect.springboot.webapp.springboot_web.models.dto.MessageDto;

@RestController
@RequestMapping("/api/pathVariable") 
public class PathVariableController {

    //Ejemplo de como usar PathVariable para recibir un parametro en la URL
    @GetMapping("/message/{msg}")
    public MessageDto getMessage(@PathVariable String msg) 
    //Nota: el nombre del parametro que se le asigna en la firma del metodo debe ser 
    //el mismo que se le asigna en la URL como se establecio en el 
    //@GetMapping("/message/{msg}") que en este caso es msg
    {
        MessageDto message = new MessageDto();
        message.setMessage(msg);
        return message;
    } 
    
    //Ejemplo para mandar multiples parametros usando PathVariable
    @GetMapping("/message/{id}/{msg}")
    public Map<String, Object> messagesByID(@PathVariable Long id, @PathVariable String msg) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("message", msg);
        return response;
        //para probarlo se puede usar la siguiente URL: http://localhost:8080/api/pathVariable/message/1/hello
    }

    //Ejemplo para mandar multiples parametros usando PathVariable considerando la configuracion required = false
    //Para usarlo, se debe especificar en las anotaciones del path ambos casos, uno omitiendo el ultimo parametro y el otro con los 2
    @GetMapping({"/message2/{id}","message2/{id}/{msg}"})
    public Map<String, Object> messagesByID2(@PathVariable Long id, @PathVariable(required = false) String msg) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("message", msg != null ? msg : "No message provided");
        return response;
        //para probarlo se puede usar la siguiente URL: http://localhost:8080/api/pathVariable/message2/1/hello
        //o http://localhost:8080/api/pathVariable/message2/1
    }

}
