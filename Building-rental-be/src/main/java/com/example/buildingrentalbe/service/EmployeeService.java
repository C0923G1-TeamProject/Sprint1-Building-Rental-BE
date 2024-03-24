package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    void changePassword(Integer id,String password){
        this.iEmployeeRepository.changedPassword(id,password);
    }


}
