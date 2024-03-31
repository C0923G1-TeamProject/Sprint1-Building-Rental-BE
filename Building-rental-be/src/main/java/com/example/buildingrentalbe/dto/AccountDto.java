package com.example.buildingrentalbe.dto;

import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.model.Role;


public class AccountDto {
    private Integer id;
    private String username;
    private String password;

    private Role role;

    private Employee employee;

    private String isVisited;

    public AccountDto() {
    }

    public AccountDto(Integer id, String username, String password, Role role, Employee employee, String isVisited) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.employee = employee;
        this.isVisited = isVisited;
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

    public String getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(String isVisited) {
        this.isVisited = isVisited;
    }
}
