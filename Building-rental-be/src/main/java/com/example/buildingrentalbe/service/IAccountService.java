package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.dto.IInformationDto;
import com.example.buildingrentalbe.model.Account;

import java.util.Optional;

public interface IAccountService {
    Account findAccountById(Integer id);
//    Optional<IInformationDto> findAccountDtoById(String accountName);
}
