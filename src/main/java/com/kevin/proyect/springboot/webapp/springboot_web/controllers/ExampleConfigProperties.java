package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/values/configExample")
public class ExampleConfigProperties {

    @Value("${conf.userMaster}")
    private String ownerName;
    @Value("${conf.userCode}")
    private Long ownerCode;
    // @Value("${conf.userDescription}")
    // private String ownnerDescription;
    
    //Ambas propiedades son iguales, pero una es un array y la otra es una lista. Se puede usar cualquiera de las dos.
    //Ya que devuelve un arreglo en json en ambos casos.
    @Value("${conf.userListValues}")
    private String[] ownerListValues;
    @Value("${conf.userListValues}")
    private List<String> ownerListValues2; 

    //tambien se puede manipular los valores de las propiedades, por ejemplo, si se requiere algun cambio, se puede modificar mediante un lenguajde de expresion del propio spring, por ejemplo, si se requiere que el valor de la propiedad sea en mayusculas, se puede hacer de la siguiente manera:
    @Value("#{'${conf.userListValues}'.toUpperCase().split(',')}")
    private List<String> ownerListValues3; //esto es un ejemplo de como se puede manipular el valor de la propiedad, en este caso, se convierte a mayusculas y se separa por comas.

    //O sino manejarlo directamente como un String y despues en algun metodo manipularlo
    @Value("#{'${conf.userListValues}'}")
    private String ownerListValues4;
    
    //Al no tener '' Se lo considera un objeto, sino seria un String
    @Value("#{${conf.productMapValues}}")
    private Map<String,Object> mapProduct;

    //Se puede acceder a sus atributos como objeto 
    @Value("#{${conf.productMapValues}.product_name}")
    private String productName;

    @Value("#{${conf.productMapValues}.product_price}")
    private Long productPrice;

    //Podemos usar tambien Enviroment
    @Autowired
    private Environment environment;

    @GetMapping("/propertiesOwner")
    public Map<String,Object> getMethodName(@Value("${conf.userDescription}") String ownnerDescription) {
        Map<String, Object> json = new HashMap<>();
        json.put("ownerName", ownerName);
        json.put("ownerCode", ownerCode); 
        json.put("ownnerDescription", ownnerDescription);
        json.put("ownerListValues", ownerListValues);
        json.put("ownerListValues2", ownerListValues2);
        json.put("ownerListValues3", ownerListValues3);
        //Aqui como llega como un String se puede manipular, en este caso solo lo convierte a mayusculas, pero se puede hacer cualquier tipo de manipulacion.
        //Despues de eso se puede convertir a un arreglo o lista, dependiendo de lo que se requiera.
        json.put("ownerListValues4", ownerListValues4.toUpperCase());
        json.put("product1", mapProduct);
        
        //Ejemplos de como acceder a los atributos de un objeto, en este caso, el objeto es un mapa, por lo que se accede a sus atributos como si fuera un objeto normal.
        json.put("productName", productName);
        json.put("productPrice", productPrice);
        
        //otra forma de acceder a una propiedad es mediante el Environment, que es una interfaz que permite acceder a las propiedades de la aplicacion, en este caso se accede a la propiedad conf.userDescription.
        //Hay que considerar que siempre devuelve un String, si se requiere otro tipo de dato, se debe convertir.
        json.put("descriptionEnvironment", environment.getProperty("conf.userDescription"));
        json.put("codeEnvironmentString", environment.getProperty("conf.userCode")); //aqui como String
        json.put("codeEnvironmentLong1", Long.valueOf(environment.getProperty("conf.userCode"))); //aqui como Long pero haciendo conversion usando un metodo externo
        json.put("codeEnvironmentLong2", environment.getProperty("conf.userCode", Long.class)); //aqui como Long pero usando el metodo de la interfaz Environment, que devuelve el tipo de dato que se le pasa como parametro.
        json.put("codeEnvironmentLong3", environment.getProperty("conf.userCode", Long.class, 0L)); //aqui como Long pero usando el metodo de la interfaz Environment, que devuelve el tipo de dato que se le pasa como parametro y si no existe la propiedad devuelve el valor por defecto que se le pasa como parametro.
        return json;
    }
    


}
