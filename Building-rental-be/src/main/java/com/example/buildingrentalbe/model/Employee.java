package com.example.buildingrentalbe.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String date;
    @Column(columnDefinition = "bit(1) default 0")
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String startDate;
    private String salaryLevel;
    private String department;
    private String email;

    @Column(columnDefinition = "text")
    private String profilePicture;

    public Employee() {
    }

    public Employee(Integer id, String code, String name, String date, boolean gender, String address, String phoneNumber, String startDate, String salaryLevel, String department, String email, String profilePicture) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.salaryLevel = salaryLevel;
        this.department = department;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(String salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
