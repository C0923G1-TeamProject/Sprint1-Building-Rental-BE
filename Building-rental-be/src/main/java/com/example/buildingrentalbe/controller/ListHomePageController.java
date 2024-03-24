package com.example.buildingrentalbe.controller;
import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.service.IPremisesService;
import com.example.buildingrentalbe.service.IPremisesStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class ListHomePageController {
    @Autowired
    IPremisesStatusService premisesStatusService;

    @Autowired
    IPremisesService premisesService;

    @GetMapping("/homePage")
    public ResponseEntity<List<Premises>> homePage(){
        List<Premises> premisesList=  premisesService.findAll();
        return new ResponseEntity<>(premisesList, HttpStatus.OK);
    }
}
