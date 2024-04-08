package com.example.buildingrentalbe.service.impl;


import com.example.buildingrentalbe.dto.ImageDto;
import com.example.buildingrentalbe.model.Employee;

import com.example.buildingrentalbe.repository.IEmployeeRepository;
import com.example.buildingrentalbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Employee findByUserNameAccount(String username) {
        return  iEmployeeRepository.findByUsernameAccount(username);
    }

    @Override
    public Employee findAccountByEmail(String email) {
        return this.iEmployeeRepository.findAccountByEmail(email);
    }

    @Override
    public void updateInformationUser(Employee employee) {
        this.iEmployeeRepository.updateInformationUser(employee);
    }

    @Override
    public void updateImage(ImageDto imageDto) {
        this.iEmployeeRepository.updateImageUser(imageDto);
    }
}
