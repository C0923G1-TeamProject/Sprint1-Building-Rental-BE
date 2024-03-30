package com.example.buildingrentalbe.dto;

public class RequestContractDto {
    private Integer page;
    private Integer size;
    private String nameCustomer;

    private Integer idContractStatus;

    public RequestContractDto(Integer page, Integer size, String nameCustomer, Integer idContractStatus) {
        this.page = page;
        this.size = size;
        this.nameCustomer = nameCustomer;
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

    public Integer getIdContractStatus() {
        return idContractStatus;
    }

    public void setIdContractStatus(Integer idContractStatus) {
        this.idContractStatus = idContractStatus;
    }
}
