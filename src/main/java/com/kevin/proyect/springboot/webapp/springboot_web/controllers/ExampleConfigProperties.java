package com.kevin.proyect.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${conf.userListValues}")
    private String[] ownerListValues;

    @GetMapping("/propertiesOwner")
    public Map<String,Object> getMethodName(@Value("${conf.userDescription}") String ownnerDescription) {
        Map<String, Object> json = new HashMap<>();
        json.put("ownerName", ownerName);
        json.put("ownerCode", ownerCode); 
        json.put("ownnerDescription", ownnerDescription);
        json.put("ownerListValues", ownerListValues);
        return json;
    }
    


}
