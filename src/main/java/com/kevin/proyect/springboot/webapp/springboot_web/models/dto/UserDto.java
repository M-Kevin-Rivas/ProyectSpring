package com.kevin.proyect.springboot.webapp.springboot_web.models.dto;

import com.kevin.proyect.springboot.webapp.springboot_web.models.User;

public class UserDto {

    private String title;
    private User userDto;

    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUserDto() {
        return userDto;
    }
    public void setUserDto(User userDto) {
        this.userDto = userDto;
    }

    

}
