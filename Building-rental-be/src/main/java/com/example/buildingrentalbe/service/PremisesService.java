package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.repository.IPremisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PremisesService implements  IPremisesService{
@Autowired
private IPremisesRepository premisesRepository;

@Override
    public List<Premises> findAll() {
        return null;
    }
}
