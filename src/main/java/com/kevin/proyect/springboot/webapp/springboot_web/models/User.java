package com.kevin.proyect.springboot.webapp.springboot_web.models;

public class User {

    private String  id_user;
    private String name_user;
    private int age_user;
    private String email_user;
    
    public User(String id_user, String name_user, int age_user, String email_user) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.age_user = age_user;
        this.email_user = email_user;
    }

    public String getId_user() {
        return id_user;
    }
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    public String getName_user() {
        return name_user;
    }
    public void setName_user(String name_user) {
        this.name_user = name_user;
    }
    public int getAge_user() {
        return age_user;
    }
    public void setAge_user(int age_user) {
        this.age_user = age_user;
    }
    public String getEmail_user() {
        return email_user;
    }
    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

}
