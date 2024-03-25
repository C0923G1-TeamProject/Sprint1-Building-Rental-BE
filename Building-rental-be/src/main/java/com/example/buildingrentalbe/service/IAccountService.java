package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.Account;

public interface IAccountService {
    Account findAccountById(Integer id);
//    Optional<IInformationDto> findAccountDtoById(String accountName);
    Account findAccountByUsername(String username);

    void changePassword(String encode, Integer id);
}
