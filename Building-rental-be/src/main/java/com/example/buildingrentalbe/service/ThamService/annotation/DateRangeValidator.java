package com.example.buildingrentalbe.service.ThamService.annotation;

import com.example.buildingrentalbe.dto.ContractDto;
import com.example.buildingrentalbe.model.Contract;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<DateRange, LocalDate> {


    @Override
    public void initialize(DateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null values are considered valid
        }

        // Lấy ra các thông tin về ngày bắt đầu và ngày kết thúc
//        LocalDate startDate = contractDto.getStartDate();
//        LocalDate endDate = contractDto.getEndDate();

        // Kiểm tra xem ngày kết thúc có lớn hơn ngày bắt đầu không
//        return endDate == null || !endDate.isBefore(startDate);
        return false;
    }
}
