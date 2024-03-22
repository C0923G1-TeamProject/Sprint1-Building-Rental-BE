package com.example.buildingrentalbe.model;

import jakarta.persistence.*;

@Entity
public class Premises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private Long price;
    private Integer floor;
    private Long cost;
    private Float area;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_type_premises")
    private TypePremises typePremises;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_premises_status")
    private PremisesStatus premisesStatus;

    public Premises() {
    }

    public Premises(Integer id, String code, Long price, Integer floor, Long cost, Float area, String description, TypePremises typePremises, PremisesStatus premisesStatus) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.floor = floor;
        this.cost = cost;
        this.area = area;
        this.description = description;
        this.typePremises = typePremises;
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

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypePremises getTypePremises() {
        return typePremises;
    }

    public void setTypePremises(TypePremises typePremises) {
        this.typePremises = typePremises;
    }

    public PremisesStatus getPremisesStatus() {
        return premisesStatus;
    }

    public void setPremisesStatus(PremisesStatus premisesStatus) {
        this.premisesStatus = premisesStatus;
    }
}
