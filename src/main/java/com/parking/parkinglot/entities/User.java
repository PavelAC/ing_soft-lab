package com.parking.parkinglot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    private Long id;



    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String username;

    @Basic
    @Column(unique=true,nullable=false,length=100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private Collection<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "owner", orphanRemoval = true)
    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    private String email;


    @Email
    @Column(unique=true,nullable=false,length=100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}