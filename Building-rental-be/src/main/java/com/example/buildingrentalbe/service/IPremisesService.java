package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.Premises;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPremisesService {
    Page<Premises> findAll (String search, Pageable pageable, String typePremisesId);

    public Page<Premises> searchPremises(Integer floor, String code, Float area, String premisesName, Pageable pageable);

    Premises findPremisesByCode(String code);

    Premises findById(int id);


}
