package com.example.buildingrentalbe.controller;


import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.service.IPremisesService;
import com.example.buildingrentalbe.service.IPremisesStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PremisesController {
    @Autowired
    IPremisesStatusService premisesStatusService;

    @Autowired
    IPremisesService premisesService;

    @GetMapping("/homePage")
    public String homePage(Model model){
        List<Premises> premisesList=  premisesService.findAll();
        return "/premises/homePage";
    }

}
