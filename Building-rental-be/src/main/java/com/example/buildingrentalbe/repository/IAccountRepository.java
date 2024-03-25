package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.dto.IInformationDto;
import com.example.buildingrentalbe.dto.InformationDto;
import com.example.buildingrentalbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account,Integer> {

    @Query(value = "select account.* from account " +
            "where account.id = :id",nativeQuery = true)
    Account findAccountById(@Param("id") Integer id);

    @Query(value = "select account.* from account where account.username = :username",nativeQuery = true)
    Account findAccountByUsername(@Param("username") String username);

    @Query(value = "update account set password = :password where account.id = :id",nativeQuery = true)
    void updatePassword(@Param("password") String encode,@Param("id") Integer id);

//    @Query(value = "update account ",nativeQuery = true)
}
