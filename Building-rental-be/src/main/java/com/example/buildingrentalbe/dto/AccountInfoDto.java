package com.example.buildingrentalbe.dto;

import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.model.Role;

public class AccountInfoDto {
    private Integer id;
    private String username;
    private String password;
    private Role role;
    private Employee employee;

    private String email;
    private String name;
    private String otp;

    public AccountInfoDto() {
    }

    public AccountInfoDto(Integer id, String username, String password, Role role, Employee employee, String email, String name, String otp) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.employee = employee;
        this.email = email;
        this.name = name;
        this.otp = otp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
