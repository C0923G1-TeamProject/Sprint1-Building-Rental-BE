package com.example.buildingrentalbe.service.ThamService;

import com.example.buildingrentalbe.model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();


    List<Contract> findContractByAccount(Integer idAccount);
}
