package com.example.buildingrentalbe.service.impl;


import com.example.buildingrentalbe.model.PremisesStatus;
import com.example.buildingrentalbe.repository.IPremisesStatusRepository;
import com.example.buildingrentalbe.service.IPremisesStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PremisesStatusService implements IPremisesStatusService {
    @Autowired
    IPremisesStatusRepository premisesStatusRepository;

    @Override
    public List<PremisesStatus> findAllPremisesStatus() {
        return premisesStatusRepository.findAll();
    }
}
