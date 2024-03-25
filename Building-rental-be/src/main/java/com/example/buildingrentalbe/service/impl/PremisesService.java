package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.model.PremisesStatus;
import com.example.buildingrentalbe.repository.IPremisesRepository;
import com.example.buildingrentalbe.service.IPremisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PremisesService implements IPremisesService {
    @Autowired
    private IPremisesRepository premisesRepository;

    @Override
    public List<Premises> findAll() {
        return premisesRepository.findAllPremises();
    }
}
