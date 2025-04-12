package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;


import com.kevin.proyect.springboot.webapp.springboot_web.models.dto.MessageDto;
import com.kevin.proyect.springboot.webapp.springboot_web.models.dto.MessageMixDto;

@RestController
@RequestMapping("/api/requestParam") //El nombre de la ruta es /api/requestParam en el navegador
public class RequestParamController {

    @GetMapping("/messageURL") //El nombre de la ruta es /api/requestParam/message en el navegador
    public MessageDto getMessageFromURL(@RequestParam(required = false, defaultValue = "Otro mensaje por defecto desde el ingreso de parametros del metodo", name="mensaje") String param_message) {
        //required=false indica que el parametro no es obligatorio, si no se envia se le asigna el valor por defecto si lo tuviera o sino mandara null
        //defaultValue indica el valor por defecto que se le asigna al parametro si no se envia
        //name="mensaje" indica el nombre del parametro que se espera recibir en la URL, esto no es obligatorio usar
            //si no se usa se le asigna el nombre del parametro que se le asigna en la firma del metodo que en este caso es param_message
        MessageDto messageFromURL = new MessageDto();
        messageFromURL.setMessage(param_message);
        //messageFromURL.setMessage(param_message != null? param_message:"Mensaje por defecto desde el controlador"); //Se le asigna el valor del parametro que se recibe por la URL, si no existe se le asigna un mensaje por defecto
        //Se puede usar el operador ternario para asignar un valor a una variable dependiendo de si se cumple una condicion o no
        return messageFromURL;
        //Para probarlo se debe ingresar la URL http://localhost:8080/api/requestParam/message?mensaje=AquipuedeIngresarElMensajeQueQuiera esto cuando se usa con la configuracion name="mensaje"
        //Si no se usa el name="Mensaje" se debe ingresar la URL http://localhost:8080/api/requestParam/message?param_message=AquipuedeIngresarElMensajeQueQuiera
    }

    @GetMapping("/messageMix")
    public MessageMixDto getNewMessageMix(@RequestParam(required = false, defaultValue = "Otro mensaje por defecto desde el ingreso de parametros del metodo") String msg, @RequestParam(required = false, defaultValue = "-1") Integer code) {
        MessageMixDto messageMix = new MessageMixDto();
        messageMix.setMessage(msg);
        messageMix.setCode(code);
        return messageMix;
        //Para probarlo se debe ingresar la URL http://localhost:8080/api/requestParam/messageMix?msg=AquipuedeIngresarElMensajeQueQuiera&code=IngresarCualquierNumero
        //Esto es cuando se quiere ingresar varios parametros a la vez, se separan por el simbolo '&' y se le asigna el valor que se quiere ingresar
        //OJO si se asigna un tipo de dato que no corresponde como en el caso del parametro code que solo recibe numeros y en lugar de eso se le manda otro tipo, se rompe la aplicacion
        //y se debe reiniciar el servidor, esto es porque no se le asigna un valor por defecto y no se puede convertir el tipo de dato que se le asigna al parametro
    }
    
}
