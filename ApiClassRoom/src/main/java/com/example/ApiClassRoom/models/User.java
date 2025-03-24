package com.example.ApiClassRoom.models;

import com.example.ApiClassRoom.helpers.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")

    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(unique = true, nullable = false, length = 150)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false)
    private UserType userType;

    public User() {
    }

    public User(Integer id, String name, String email, String password, String phone, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
