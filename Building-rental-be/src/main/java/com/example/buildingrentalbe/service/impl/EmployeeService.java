package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.dto.IInformationDto;
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
    public List<IInformationDto> getInfo(String accountName) {
        return iEmployeeRepository.personalInformation(accountName);
    }

    @Override
    public void changePassword(Integer id, String password) {
        this.iEmployeeRepository.changedPassword(id,password);
    }

//    @Override
//    public IInformationDto findAccountById(Integer id) {
//        return this.iEmployeeRepository.findById(id);
//    }
}
