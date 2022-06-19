package com.armanfar.webservice.webservicedemo.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

// @JsonIgnoreProperties(value = {"birthdate"})
// @JsonFilter("UserFilter")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Column
    @Past(message = "Birthdate should be in the past")
    private Date birthdate;

    // @JsonIgnore
    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User() {}

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "user [birthdate=" + birthdate + ", id=" + id + ", name=" + name + "]";
    }

    
}
