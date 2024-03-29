package com.example.buildingrentalbe.dto;

import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.ContractStatus;
import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.model.Premises;
//import com.example.buildingrentalbe.service.ThamService.annotation.DateRange;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class ContractDto implements Validator {

    private Integer id;
    private String code;

    @FutureOrPresent(message = "Ngày bắt đầu hợp đồng không được nhỏ hơn ngày hiện tại")
    @NotNull
    private LocalDate startDate;
    @Future(message = "Ngày kết thúc hợp đồng phải lớn hơn ngày hiện tại")
    @NotNull
    private LocalDate endDate;
    @Min(0)
    @Max(1000000000)
    @NotNull
    private Long deposit;
    @NotBlank(message = "Nội dung hợp đồng không được để trống")
    private String content;

    @NotNull(message = "Nội dung nay không được để trống")
    private String paymentTerm;
    @NotNull(message = "Nội dung nay không được để trống")
    private Integer idPremises;
    @NotNull(message = "Nội dung nay không được để trống")
    private Integer idCustomer;
    @NotNull(message = "Nội dung nay không được để trống")
    private Integer idAccount;
    @NotNull(message = "Nội dung nay không được để trống")
    private Integer idContractStatus;

    public ContractDto(Integer id, String code, LocalDate startDate, LocalDate endDate, Long deposit, String content, String paymentTerm, Integer idPremises, Integer idCustomer, Integer idAccount, Integer idContractStatus) {
        this.id = id;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.content = content;
        this.paymentTerm = paymentTerm;
        this.idPremises = idPremises;
        this.idCustomer = idCustomer;
        this.idAccount = idAccount;
        this.idContractStatus = idContractStatus;
    }

    public ContractDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public Integer getIdPremises() {
        return idPremises;
    }

    public void setIdPremises(Integer idPremises) {
        this.idPremises = idPremises;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Integer getIdContractStatus() {
        return idContractStatus;
    }

    public void setIdContractStatus(Integer idContractStatus) {
        this.idContractStatus = idContractStatus;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (contractDto.getEndDate() != null && contractDto.getEndDate() != null) {
            if (contractDto.getStartDate().isAfter(contractDto.getEndDate())) {
                errors.rejectValue("startDate", "startDate.invalid", "Ngày kết thúc hợp đồng không thể nhỏ hơn hoặc bằng ngày bắt đầu");
            }
        }
    }

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }
}
