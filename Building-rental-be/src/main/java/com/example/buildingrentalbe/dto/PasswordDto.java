package com.example.buildingrentalbe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PasswordDto {
    @NotBlank(message = "Mật khẩu không được bỏ trống!")
    private String currentPassword;
    @NotBlank(message = "Mật khẩu không được bỏ trống")
    @Size(min = 6,max = 24,message = "Mật khẩu có độ dài từ 6-24 kí tự")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]$", message = "Mật khẩu ít nhất chứa 1 chữ cái thường, 1 chữ cái hoa, 1 số 0-9 và 1 kí tự đặc biệt như(@$!%*?&)")
    private String newPassword;
    @NotBlank(message = "Mật khẩu không được bỏ trống")
    @Size(min = 6,max = 24,message = "Mật khẩu có độ dài từ 6-24 kí tự")
    private String confirmNewPassword;

    public PasswordDto() {
    }

    public PasswordDto(String currentPassword, String newPassword, String confirmNewPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
