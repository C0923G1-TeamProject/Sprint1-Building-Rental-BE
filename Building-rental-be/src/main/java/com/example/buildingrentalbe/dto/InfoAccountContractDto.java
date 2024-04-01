package com.example.buildingrentalbe.dto;

public class InfoAccountContractDto {
    private String nameEmployee;
    private Integer idAccount;

    public InfoAccountContractDto(String nameEmployee, Integer idAccount) {
        this.nameEmployee = nameEmployee;
        this.idAccount = idAccount;
    }

    public InfoAccountContractDto() {
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }
}
