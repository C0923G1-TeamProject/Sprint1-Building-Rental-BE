package com.example.buildingrentalbe.controller;
import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.service.impl.PremisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PremisesController {

    @Autowired
    PremisesService premisesService;

    @GetMapping("/premises/search")
    public ResponseEntity<Page<Premises>> searchPremises(
            @RequestParam( required = false) Integer floor,
            @RequestParam( required = false) String code,
            @RequestParam( required = false) Float area,
            @RequestParam( required = false) String premisesName,
            @RequestParam( defaultValue = "0") int page,
            @RequestParam( defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Premises> result = premisesService.searchPremises(floor, code, area, premisesName, pageable);
        if(result.getTotalPages() > 0){
            return ResponseEntity.ok().body(result);
        }else {
            return ResponseEntity.noContent().build();
        }
    }}
