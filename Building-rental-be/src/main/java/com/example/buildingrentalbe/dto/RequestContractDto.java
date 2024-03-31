package com.example.buildingrentalbe.dto;

public class RequestContractDto {
    private Integer page;
    private Integer size;
    private String nameCustomer;
    private String nameEmployee;
    private Integer idContractStatus;

    public RequestContractDto(Integer page, Integer size, String nameCustomer, String nameEmployee, Integer idContractStatus) {
        this.page = page;
        this.size = size;
        this.nameCustomer = nameCustomer;
        this.nameEmployee = nameEmployee;
        this.idContractStatus = idContractStatus;
    }

    public RequestContractDto() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Integer getIdContractStatus() {
        return idContractStatus;
    }

    public void setIdContractStatus(Integer idContractStatus) {
        this.idContractStatus = idContractStatus;
    }
}
