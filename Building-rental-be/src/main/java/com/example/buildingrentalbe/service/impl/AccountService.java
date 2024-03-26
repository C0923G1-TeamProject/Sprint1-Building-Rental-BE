package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.repository.IAccountRepository;
import com.example.buildingrentalbe.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Account findAccountById(Integer id) {
        return this.iAccountRepository.findAccountById(id);
    }

    @Override
    public Account findAccountByUsername(String username) {
        return this.iAccountRepository.findAccountByUsername(username);
    }

    @Override
    public void changePassword(String encode, Integer id) {
        this.iAccountRepository.updatePassword(encode,id);
    }

//    @Override
//    public Optional<IInformationDto> findAccountDtoById(String accountName) {
//        return this.iAccountRepository.findAccountDtoById(accountName);
//    }
}