package com.kevin.proyect.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
//Esta es una clase creada para cargar archivos que tengan la configuracion .properties
//Con el fin de mantener la clase principal mas limpia y ordenada
//Esta clase se puede usar para cargar varios archivos .properties, se pueden agregar mas dentro de la lista de PropertySources
//Para crear este tipo de clases tiene que estar al mismo nivel con respecto a su ubicacion que la clase principal
//En este caso la clase principal es SpringbootWebApplication y esta clase ValuesConfig tiene que estar en el mismo paquete que la clase principal
@Configuration
@PropertySources({
	@PropertySource(value="classpath:values.properties",encoding = "UTF-8") //Cargar el archivo values.properties, se puede cargar mas de 1 dentro de esta lista
	//NOTA: Si en el archivo properties se usan caracteres especiales como la ñ o acentos, se debe especificar el encoding = "UTF-8" para que los reconozca
})

public class ValuesConfig {

}
