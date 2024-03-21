package com.example.buildingrentalbe.model;

import jakarta.persistence.*;

@Entity
public class Premises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String typeOfPremises;
    private Long price;
    private Integer floor;
    private Long cost;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_premises_status")
    private PremisesStatus premisesStatus;

    public Premises() {
    }

    public Premises(Integer id, String code, String typeOfPremises, Long price, Integer floor, Long cost, PremisesStatus premisesStatus) {
        this.id = id;
        this.code = code;
        this.typeOfPremises = typeOfPremises;
        this.price = price;
        this.floor = floor;
        this.cost = cost;
        this.premisesStatus = premisesStatus;
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

    public String getTypeOfPremises() {
        return typeOfPremises;
    }

    public void setTypeOfPremises(String typeOfPremises) {
        this.typeOfPremises = typeOfPremises;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public PremisesStatus getPremisesStatus() {
        return premisesStatus;
    }

    public void setPremisesStatus(PremisesStatus premisesStatus) {
        this.premisesStatus = premisesStatus;
    }
}
