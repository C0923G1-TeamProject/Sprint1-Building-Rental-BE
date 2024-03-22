package com.example.buildingrentalbe.service;


import com.example.buildingrentalbe.model.PremisesStatus;
import com.example.buildingrentalbe.repository.IPremisesStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PremisesStatusService implements  IPremisesStatusService{
    @Autowired
    private IPremisesStatusRepository premisesStatusRepository;

    @Override
    public List<PremisesStatus> findAll() {
        return null;
    }
}
