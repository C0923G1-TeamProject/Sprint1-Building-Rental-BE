package com.example.buildingrentalbe.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class InformationDto implements Validator {
    private Integer id;

    @NotBlank(message = "Ngày sinh không được để trống")
    private String date;
    @NotBlank(message = "Địa chỉ không được để trống")
    @Pattern(regexp = "^[\\p{L}\\p{M}0-9\\s,.]+$", message = "Vui lòng nhập địa chỉ hợp lệ")
    @Size(min = 4, max = 100, message = "Địa chỉ ít nhất phải chứa hơn 4 kí tự và không được chứa hơn 100 kí tự")
    private String address;
    @NotBlank(message = "Họ và tên Không được để trống")
    @Pattern(regexp = "^[\\p{L}\\p{M}\\s]+$", message = "Vui lòng nhập Họ và tên hợp lệ")
    @Size(min = 1, max = 50, message = "Họ và tên ít nhất phải chứa hơn 1 kí tự và không được chứa hơn 50 kí tự")
    private String name;
    private boolean gender;
    @NotBlank(message = "Email Không được để trống")
    @Pattern(regexp = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$", message = "Vui lòng nhập email đúng định dạng")
    private String email;

    public InformationDto() {
    }

    public InformationDto(Integer id, String date, String address, String name, boolean gender, String email) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        InformationDto informationDto = (InformationDto) target;
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate birthday = LocalDate.parse(informationDto.getDate().toString(), formatter);
            LocalDate now = LocalDate.now();
            int age = Period.between(birthday, now).getYears();
            if (age < 18) {
                errors.rejectValue("date", "", "Bạn chưa đủ 18 tuổi!");
            }
        } catch (Exception e) {
            errors.rejectValue("date", "", "age");
        }


    }
}
