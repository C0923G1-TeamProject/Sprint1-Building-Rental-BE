package com.example.buildingrentalbe.repository;


import com.example.buildingrentalbe.dto.ImageDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "select account.* from account " +
            "where account.id = :id", nativeQuery = true)
    Account findAccountById(@Param("id") Integer id);

    @Query(value = "select account.* from account where account.username = :username", nativeQuery = true)
    Account findAccountByUsername(@Param("username") String username);


    @Transactional
    @Modifying
    @Query(value = "update account set password = :password where account.id = :id", nativeQuery = true)
    void updatePassword(@Param("password") String encode, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update employee set name = :#{#employee.name},address = :#{#employee.address},date = :#{#employee.date}, " +
            "email= :#{#employee.email}, gender= :#{#employee.gender} where id= :#{#employee.id}", nativeQuery = true)
    void updateInformationUser(@Param("employee") Employee employee);


    @Transactional
    @Modifying
    @Query(value = "update employee set profile_picture = :#{#imageDto.imageUrl} where id = :#{#imageDto.id}", nativeQuery = true)
    void updateImageUser(@Param("imageDto") ImageDto imageDto);

}
