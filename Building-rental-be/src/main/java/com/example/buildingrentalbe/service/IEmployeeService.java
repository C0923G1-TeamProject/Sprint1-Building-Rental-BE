package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.dto.ImageDto;
import com.example.buildingrentalbe.model.Employee;

public interface IEmployeeService {
    Employee findByUserNameAccount(String username);
    Employee findAccountByEmail(String email);
    void updateInformationUser(Employee employee);

    void updateImage(ImageDto imageDto);

}
