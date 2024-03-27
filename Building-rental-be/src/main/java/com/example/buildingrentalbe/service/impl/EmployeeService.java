package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.dto.IInformationDto;
import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.repository.IEmployeeRepository;
import com.example.buildingrentalbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Employee findByUserNameAccount(String username) {
        return  iEmployeeRepository.findByUsernameAccount(username);
    }
}
