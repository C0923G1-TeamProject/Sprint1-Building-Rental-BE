package com.example.buildingrentalbe.dto;

import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.ContractStatus;
import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.model.Premises;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public interface IContractSearchDto {
    Integer getIdContract();
    String getCode();
    LocalDate getStartDate();
    LocalDate getEndDate();
    Long getDeposit();
    String getContent();

    String getPaymentTerm();

    String getCodePremises();

   String getNameCustomer();

   String getNameAccount();

    String getContractStatus();
}
