package com.example.buildingrentalbe.controller;


import com.example.buildingrentalbe.dto.InformationDto;
import com.example.buildingrentalbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/information")
public class InfoController {
    @Autowired
    private IEmployeeService iEmployeeService;


    @GetMapping("/")
    public ResponseEntity<?> informationPersonalOfEmpById(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
