package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.model.TypePremises;
import com.example.buildingrentalbe.repository.ITypePremisesRepository;
import com.example.buildingrentalbe.service.ITypePremisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePremisesService implements ITypePremisesService {
    @Autowired
    ITypePremisesRepository typePremisesRepository;

    @Override
    public List<TypePremises> findAllType() {
        return typePremisesRepository.findAll();
    }
}
