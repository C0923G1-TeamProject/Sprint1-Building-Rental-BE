package com.example.buildingrentalbe.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class PremisesDTO {
    private Integer id;
    @Pattern(regexp = "^MB-[0-9]{4}+$",message = "Mã mặt bằng phải có dạng MB-XXXX")
    private String code;
    @NotNull
    private Integer floor;

    @NotNull
    private Integer typeId;

    @NotNull
    private Integer statusId;


    @DecimalMin(value = "10.0")
    @DecimalMax(value = "999999.9")
    private Float area;
    @Size(max = 255, message = "Mô tả tối đa 255 kí tự")
    private String description;

    @Min(1000)
    @Max(999999999)
    @Digits(integer = 9, fraction = 0, message = "Giá thuê phải lớn hơn 1 và < 9,999,999,999")
    private Long price;

    @Min(1000)
    @Max(999999999)
    @Digits(integer = 9, fraction = 0, message = "Phí quản lý phải lớn hơn 1 và < 9,999,999,999")
    private Long cost;

    public PremisesDTO() {
    }

    public PremisesDTO(String code, Integer floor, Integer typeId, Integer statusId, Float area, String description, Long price, Long cost) {
        this.code = code;
        this.floor = floor;
        this.typeId = typeId;
        this.statusId = statusId;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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
