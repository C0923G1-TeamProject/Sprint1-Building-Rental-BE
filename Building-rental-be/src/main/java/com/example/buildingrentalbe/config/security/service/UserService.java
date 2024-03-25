package com.example.buildingrentalbe.config.security.service;

import com.example.buildingrentalbe.config.security.secConfig.UserPrinciple;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IAccountRepository iAccountRepository;

    public Account findByUsername(String name) {
        return iAccountRepository.findAccountByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserPrinciple.build(iAccountRepository.findAccountByUsername(username));
    }
}
