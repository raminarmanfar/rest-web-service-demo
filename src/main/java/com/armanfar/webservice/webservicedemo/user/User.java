package com.armanfar.webservice.webservicedemo.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

// @JsonIgnoreProperties(value = {"birthdate"})
@JsonFilter("UserFilter")
public class User {

    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private Date birthdate;

    // @JsonIgnore
    private String password;

    public User(Integer id, String name, Date birthdate, String password) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.password = password;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user [birthdate=" + birthdate + ", id=" + id + ", name=" + name + "]";
    }

    
}
