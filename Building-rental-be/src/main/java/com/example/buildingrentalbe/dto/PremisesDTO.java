package com.example.buildingrentalbe.dto;

import com.example.buildingrentalbe.model.PremisesStatus;
import com.example.buildingrentalbe.model.TypePremises;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PremisesDTO {
    private Integer id;
    @Pattern(regexp = "^MB-[0-9]{4}$",message = "Mã mặt bằng phải có dạng MB-XXXX")
    private String code;
    @NotNull
    private Integer floor;

    @NotNull
    private TypePremises typePremises;

    @NotNull
    private PremisesStatus premisesStatus;


    @DecimalMin(value = "10.0")
    @DecimalMax(value = "999999.9")
    private Float area;
    @Size(max = 1500, message = "Mô tả tối đa 1500 kí tự")
    private String description;

    @NotNull
    @Min(1000)
    @Max(999999999)
    @Digits(integer = 12, fraction = 0, message = "Giá thuê phải lớn hơn 1 và < 9,999,999,999,999")
    private Long price;

    @NotNull
    @Min(1000)
    @Max(999999999)
    @Digits(integer = 12, fraction = 0, message = "Phí quản lý phải lớn hơn 1 và < 9,999,999,999,999")
    private Long cost;


    public PremisesDTO() {
    }

    public PremisesDTO(Integer id, String code, Integer floor, TypePremises typePremises, PremisesStatus premisesStatus, Float area, String description, Long price, Long cost) {
        this.id = id;
        this.code = code;
        this.floor = floor;
        this.typePremises = typePremises;
        this.premisesStatus = premisesStatus;
        this.area = area;
        this.description = description;
        this.price = price;
        this.cost = cost;

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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

}
