package com.parking.parkinglot.common;

public class UserDto {

    public Long getId() {
        return id;
    }


    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return username;
    }

    Long id;
    String Email;
    String Password;
    String username;

    public UserDto(Long id, String email, String password, String username) {
        this.id = id;
        this.Email = email;
        this.Password = password;
        this.username = username;
    }
}
