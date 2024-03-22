package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.PremisesStatus;

import java.util.List;

public interface IPremisesStatusService {
    List<PremisesStatus> findAll();
}
