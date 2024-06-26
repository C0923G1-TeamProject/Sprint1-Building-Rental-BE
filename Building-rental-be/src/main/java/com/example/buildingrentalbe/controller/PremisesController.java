package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.dto.PremisesDTO;
import com.example.buildingrentalbe.dto.PremisesDetailDTO;
import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.model.PremisesStatus;
import com.example.buildingrentalbe.model.TypePremises;
import com.example.buildingrentalbe.service.impl.PremisesService;
import com.example.buildingrentalbe.service.impl.PremisesStatusService;
import com.example.buildingrentalbe.service.impl.TypePremisesService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;




@RestController
@CrossOrigin("*")
@RequestMapping("/api/premises")
public class PremisesController {

    @Autowired
    PremisesService premisesService;

    @Autowired
    PremisesStatusService premisesStatusService;

    @Autowired
    TypePremisesService typePremisesService;




//    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")

    @GetMapping("/search")
    public ResponseEntity<Page<Premises>> searchPremises(
            @RequestParam( required = false) Integer floor,
            @RequestParam( required = false) String code,
            @RequestParam( required = false) Float area,
            @RequestParam( required = false) String premisesName,
            @RequestParam( defaultValue = "0") int page,
            @RequestParam( defaultValue = "6") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Premises> result = premisesService.searchPremises(floor, code, area, premisesName, pageable);
        if(result.getTotalPages() > 0){
            return ResponseEntity.ok().body(result);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

//    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @PatchMapping("/update/{id}")
    public ResponseEntity<PremisesDTO> updatePremises(@PathVariable("id") int id,
                                            @Valid @RequestBody PremisesDTO premisesDTO,
                                            BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Premises existingPremises = premisesService.findById(id);
        if (existingPremises == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!Objects.equals(existingPremises.getCode(), premisesDTO.getCode()) &&
                premisesService.findPremisesByCode(premisesDTO.getCode()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        BeanUtils.copyProperties(premisesDTO, existingPremises, "id", "image");

        premisesService.updatePremises(id, existingPremises);

        return new ResponseEntity<>(premisesDTO, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<PremisesDTO> findPremisesById(@PathVariable("id") Integer id){
        Premises premises = premisesService.findById(id);
        if (premises == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PremisesDTO premisesDTO = new PremisesDTO();
        BeanUtils.copyProperties(premises, premisesDTO);
        return new ResponseEntity<>(premisesDTO, HttpStatus.OK);
    }


    @GetMapping("/getListFloor")
        public ResponseEntity<List<Integer>> getAllFloor(){
            List<Integer> listFloor = PremisesService.getListFloor();
            if (listFloor == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<>(listFloor, HttpStatus.OK);
            }
        }


    @GetMapping("/getListType")
    public ResponseEntity<List<TypePremises>> getAllType() {
        List<TypePremises> typePremisesList = typePremisesService.findAllType();
        if(typePremisesList == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(typePremisesList, HttpStatus.OK);
        }
    }


    @GetMapping("/getListStatus")
    public ResponseEntity<List<PremisesStatus>> getAllStatus() {
        List<PremisesStatus> premisesStatusList = premisesStatusService.findAllPremisesStatus();

        if(premisesStatusList == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(premisesStatusList, HttpStatus.OK);
        }
    }

    //laasy mặt bằng chưa cho thuê để hiển thị tạo mới
    @GetMapping("/createContract")
    public ResponseEntity<?> findByStatus(){
        List<Premises> premisesList = premisesService.findByStatus();
        if(premisesList == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(premisesList, HttpStatus.OK);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PremisesDetailDTO> findPremisesDetailById(@PathVariable("id") Integer id){
        Premises premises = premisesService.findById(id);
        if (premises == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PremisesDetailDTO PremisesDetailDTO = new PremisesDetailDTO();
        BeanUtils.copyProperties(premises, PremisesDetailDTO);
        return new ResponseEntity<>(PremisesDetailDTO, HttpStatus.OK);
    }
}
