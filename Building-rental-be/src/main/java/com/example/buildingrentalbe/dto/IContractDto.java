package com.example.buildingrentalbe.dto;

import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.ContractStatus;
import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.model.Premises;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;


public interface IContractDto {
    Integer getId();
    String getCode();
    LocalDate getStartDate();
    LocalDate getEndDate();
    Long getDeposit();
    String getContent();

    String getPaymentTerm();
    interface IPremises{
        Integer getId();
        String getCode();
        Long getPrice();
        Integer getFloor();
    }
    IPremises getPremises();

    interface ICustomer{
        Integer getId();
        String getName();
    }
    ICustomer getCustomer();

    interface IAccount{
         Integer getId();
         String getUsername();
    }
    IAccount getAccount();

    IContractStatus getContractStatus();

    interface IContractStatus {
        Integer getId();
        String getName();
    }

        Integer getIdEmployee();
        String getNameEmployee();

}
