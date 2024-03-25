package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.dto.PremisesDTO;
import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.service.PremisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
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
    }


    @PatchMapping("/premises/{id}")
    public ResponseEntity<String> updatePremises(@PathVariable Integer id, @RequestBody PremisesDTO premisesDTO) {
        try {
            premisesDTO.setId(id);
            premisesService.updatePremises(premisesDTO);
            return ResponseEntity.ok("Cập nhật premises thành công");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
