package com.example.buildingrentalbe.controller;
import com.example.buildingrentalbe.dto.PremisesDTO;
import com.example.buildingrentalbe.model.Premises;


import com.example.buildingrentalbe.service.impl.PremisesService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/premises")
public class PremisesController {
    @Autowired
    PremisesService premisesService;


    @GetMapping("/search")
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

    @PatchMapping("update/{id}")
    public ResponseEntity<?> updatePremises(@PathVariable("id") int id,
                                            @Valid @RequestBody PremisesDTO premisesDTO,
                                            BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        Premises existingPremises = premisesService.findById(id);
        if (existingPremises == null) {
            return ResponseEntity.notFound().build();
        }

        if (!Objects.equals(existingPremises.getCode(), premisesDTO.getCode()) &&
                premisesService.findPremisesByCode(premisesDTO.getCode()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Mã mặt bằng đã tồn tại");
        }

        BeanUtils.copyProperties(premisesDTO, existingPremises, "id");

        premisesService.updatePremises(id, existingPremises);

        return ResponseEntity.ok("Cập nhật thông tin premises thành công");
    }}

