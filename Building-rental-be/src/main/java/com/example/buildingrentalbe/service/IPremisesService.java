package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.dto.PremisesDTO;
import com.example.buildingrentalbe.model.Premises;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPremisesService {
    List<Premises> findAll();

    public Page<Premises> searchPremises(Integer floor, String code, Float area, String premisesName, Pageable pageable);

    Premises findPremisesByCode(String code);

    Premises findById(int id);

    void updatePremises(PremisesDTO premisesDTO);


}
