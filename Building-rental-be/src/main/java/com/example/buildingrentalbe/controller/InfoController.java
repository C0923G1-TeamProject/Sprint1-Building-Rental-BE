package com.example.buildingrentalbe.controller;


import com.example.buildingrentalbe.dto.IInformationDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.service.IAccountService;
import com.example.buildingrentalbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/information")
public class InfoController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IAccountService iAccountService;

   @GetMapping("/account/{id}")
    public ResponseEntity<?> informationAccountUser(@PathVariable Integer id){
        Account account = this.iAccountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }


}
