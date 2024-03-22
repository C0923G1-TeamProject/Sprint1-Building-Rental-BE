package com.example.buildingrentalbe.service.ThamService;

import com.example.buildingrentalbe.model.Contract;
import com.example.buildingrentalbe.repository.ThamRepository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService{
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAllContract();
    }

    @Override
    public List<Contract> findContractByAccount(Integer idAccount) {
        return contractRepository.findContractByAccount(idAccount);
    }




}
