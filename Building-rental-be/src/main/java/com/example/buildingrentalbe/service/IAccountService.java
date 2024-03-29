package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.dto.ImageDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.Employee;

public interface IAccountService {
    Account findAccountById(Integer id);
    Account findAccountByUsername(String username);
    void changePassword(String encode, Integer id);
    void updateInformationUser(Employee employee);
    void updateImage(ImageDto imageDto);
}
