package com.example.buildingrentalbe.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Validator {
    private Integer id;
    @NotBlank(message = "Trường bắt buộc nhập")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Tên Không hợp lệ")
    @Size(min = 2, max = 30, message = "Tên Của Bạn từ 2 - 30 ký tự")
    private String name;
    @NotBlank(message = "Trường bắt buộc nhập")
    @Size(min = 12, max = 12, message = "Số căn cước cần chính xác 12 ký tự số")
    private String card;
    @NotBlank(message = "Trường bắt buộc nhập")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Trường bắt buộc nhập")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Dob định dạng không hợp lệ")
    private String date;
    @NotBlank(message = "Trường bắt buộc nhập")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "SĐT không hợp lệ")
    private String phoneNumber;
    @NotBlank(message = "Trường bắt buộc nhập")
    private String address;
    @Column(name = "url_website")
    @NotBlank(message = "Trường bắt buộc nhập")
    private String url;
    @NotBlank(message = "Trường bắt buộc nhập")
    private String company;
    private String img;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customer = (CustomerDto) target;
        // Kiểm tra ngày sinh có hợp lệ không
        if (customer.getDate() == null || customer.getDate().isEmpty()) {
            errors.rejectValue("date", "NotEmpty.customerDto.date", "Ngày sinh không được để trống");
        } else {
            // Chuyển đổi ngày sinh từ chuỗi sang LocalDate
            LocalDate dob = LocalDate.parse(customer.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Tính toán tuổi
            LocalDate now = LocalDate.now();
            int age = now.minusYears(18).compareTo(dob);

            // Nếu tuổi nhỏ hơn 18, ghi lỗi
            if (age < 0) {
                errors.rejectValue("date", "Invalid.customerDto.date", "Tuổi phải lớn hơn hoặc bằng 18");
            }
        }
    }
}
