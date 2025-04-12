package com.kevin.proyect.springboot.webapp.springboot_web.models.dto;

import com.kevin.proyect.springboot.webapp.springboot_web.models.User;

public class UserDto {

    private String title;
    private User userDto;
    private boolean isYoungerThan25;


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
    public boolean isYoungerThan25() {
        return isYoungerThan25;
    }
    public void setYoungerThan25(boolean isYoungerThan25) {
        this.isYoungerThan25 = isYoungerThan25;
    }

}
