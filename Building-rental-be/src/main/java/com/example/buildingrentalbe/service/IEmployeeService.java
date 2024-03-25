package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.dto.IInformationDto;

import java.util.List;

public interface IEmployeeService {

    List<IInformationDto> getInfo(String accountName);
    void changePassword(Integer id,String password);

//    IInformationDto findAccountById(Integer id);

}
