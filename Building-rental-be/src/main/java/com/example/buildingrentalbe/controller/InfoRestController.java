package com.example.buildingrentalbe.controller;


import com.example.buildingrentalbe.dto.ImageDto;
import com.example.buildingrentalbe.dto.InformationDto;
import com.example.buildingrentalbe.dto.PasswordDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.service.IAccountService;
import com.example.buildingrentalbe.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@CrossOrigin("*")
@RequestMapping("/information")
public class InfoRestController {

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * This method is responsible for handling get information user request.
     *
     * @param principal The Principal object representing the authenticated user.
     * @return ResponseEntity containing the user account information or an error message along with the appropriate HTTP status code.
     * @author: ViTKT
     * @since: 26/03/2024
     * @version: 1.0
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/getInformationUser")
    public ResponseEntity<?> showInfoUser(Principal principal) {
        Account account = this.iAccountService.findAccountByUsername(principal.getName());
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/account/{id}")
    public ResponseEntity<?> informationAccountUser(@PathVariable Integer id) {
        Account account = this.iAccountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    /**
     * This method is responsible for handling the password change request.
     * It validates the provided password information, including the current password, new password, and confirmation of the new password.
     * If the validation fails, it returns a response with a status code of 400 (Bad Request) along with error details.
     * If the provided current password matches the actual password of the user, it proceeds to check if the new password matches the confirmation password.
     * If the new password matches the confirmation password and is not the same as the current password, it changes the password successfully and returns a response with a status code of 200 (OK).
     * If the new password does not match the confirmation password, it returns a response with a status code of 400 (Bad Request) indicating that the new password does not match the confirmation.
     * If the provided current password does not match the actual password of the user, it returns a response with a status code of 400 (Bad Request) indicating that the current password is incorrect.
     *
     * @param passwordDto The PasswordDto object containing password information.
     * @param principal   The Principal object representing the authenticated user.
     * @return ResponseEntity containing a success or error message along with the appropriate HTTP status code.
     * @author: ViTKT
     * @since: 26/03/2024
     * @version: 1.0
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @PostMapping("/changed-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody PasswordDto passwordDto, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Account account = this.iAccountService.findAccountByUsername(principal.getName());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (bCryptPasswordEncoder.matches(passwordDto.getCurrentPassword(), account.getPassword())) {
            if (passwordDto.getNewPassword().equals(passwordDto.getConfirmNewPassword())) {
                if (!passwordDto.getNewPassword().equals(passwordDto.getCurrentPassword())) {
                    this.iAccountService.changePassword(bCryptPasswordEncoder.encode(passwordDto.getNewPassword()), account.getId());
                    return new ResponseEntity<>("Đổi mật khẩu thành công", HttpStatus.OK);
                } else {
                    System.out.println("MK mới đang trùng ới mk cũ");
                    return new ResponseEntity<>("Mật khẩu mới không được trùng với mật khẩu cũ!", HttpStatus.BAD_REQUEST);
                }
            } else {
                System.out.println("MK mới kh trùng");
                return new ResponseEntity<>("Mật khẩu mới không trùng khớp với xác nhận mật khẩu!", HttpStatus.BAD_REQUEST);
            }
        } else {
            System.out.println("Sai mk");
            return new ResponseEntity<>("Mật khẩu không chính xác!", HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * This method is responsible for handling the update information request
     *
     * @param informationDto the InformationDto object containing info of user
     * @return ResponseEntity containing a success with the appropriate HTTP status code.
     * @author: ViTKT
     * @since: 26/03/2024
     * @version: 1.0
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @PostMapping("/updateInformation")
    public ResponseEntity<?> updateInformation(@Valid @RequestBody InformationDto informationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Employee existingEmployee = this.iEmployeeService.findAccountByEmail(informationDto.getEmail());
        if (existingEmployee != null) {
            return new ResponseEntity<>("Email đã tồn tại!", HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(informationDto, employee);
        this.iEmployeeService.updateInformationUser(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * This method is responsible for handling the update image request
     *
     * @param imageDto the ImageDto object containing image of user
     * @return ResponseEntity containing a success with the appropriate HTTP status code.
     * @author: ViTKT
     * @since: 26/03/2024
     * @version: 1.0
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @PostMapping("/updateImage")
    public ResponseEntity<?> updateImage(@RequestBody ImageDto imageDto) {
        this.iEmployeeService.updateImage(imageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
