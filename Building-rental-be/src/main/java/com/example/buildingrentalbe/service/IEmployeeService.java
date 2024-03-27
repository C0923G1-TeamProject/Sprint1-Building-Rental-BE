package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.Employee;

public interface IEmployeeService {
    Employee findByUserNameAccount(String username);
}
