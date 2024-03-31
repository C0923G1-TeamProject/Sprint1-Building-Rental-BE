package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.Premises;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPremisesService {
    List<Premises> findAll();

    public Page<Premises> searchPremises(Integer floor, String code, Float area, String premisesName, Pageable pageable);

    Premises findPremisesByCode(String code);

    Premises findById(int id);

    void updatePremises(int id, Premises premises);

    List<Premises> findByStatus();
}
