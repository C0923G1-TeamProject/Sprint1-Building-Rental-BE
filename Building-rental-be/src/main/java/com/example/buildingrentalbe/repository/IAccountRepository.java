package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.dto.IInformationDto;
import com.example.buildingrentalbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = "select account.* from account " +
            "where account.id = :id",nativeQuery = true)
    Account findAccountById(@Param("id") Integer id);

    @Query(value = "select account.username as `username`," +
            "e.name as `name`," +
            "e.date as `date`," +
            "e.gender as `gender`"+
            "from account " +
            "left join employee as e on account.id_employee = e.id" +
            "where account.username = :account",nativeQuery = true)
    Optional<IInformationDto> findAccountDtoById(@Param("account")String accountName);
}
