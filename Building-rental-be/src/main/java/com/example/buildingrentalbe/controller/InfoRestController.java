package com.example.buildingrentalbe.controller;


import com.example.buildingrentalbe.dto.InformationDto;
import com.example.buildingrentalbe.dto.PasswordDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping("/getInformationUser")
    public ResponseEntity<?> showInfoUser(Principal principal) {
        Account account = this.iAccountService.findAccountByUsername(principal.getName());
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<?> informationAccountUser(@PathVariable Integer id) {
        Account account = this.iAccountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    @PostMapping("/changed-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody PasswordDto passwordDto, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        Account account = this.iAccountService.findAccountByUsername(principal.getName());
        System.out.println(account);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(passwordDto.getCurrentPassword(), account.getPassword())) {
            // check new pass vs confrm
            if (passwordDto.getNewPassword().equals(passwordDto.getConfirmNewPassword())) {
                this.iAccountService.changePassword(bCryptPasswordEncoder.encode(passwordDto.getNewPassword()), account.getId());
            } else {
                return new ResponseEntity<>("Mat khau moi khong trung voi xac nhan mat khau!",HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Mat khau khong chinh xac!",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Doi mat khau thanh cong",HttpStatus.OK);
    }

    @PostMapping("/updateInformation")
    public ResponseEntity<?> updateInformation(@Valid @RequestBody InformationDto informationDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(informationDto,employee);
        this.iAccountService.updateInformationUser(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


}
