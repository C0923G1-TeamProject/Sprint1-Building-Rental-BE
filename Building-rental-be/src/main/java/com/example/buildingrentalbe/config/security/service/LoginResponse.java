package com.example.buildingrentalbe.config.security.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class LoginResponse {
    private Integer id;
    private String token;
    private String type = "Bearer";
    private String username;
    private String name;
    private String otp;
    private String statusLogin;

    private String email;

    public LoginResponse() {
    }

    public LoginResponse(String otp, String statusLogin, String email) {
        this.otp = otp;
        this.statusLogin = statusLogin;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(String statusLogin) {
        this.statusLogin = statusLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
