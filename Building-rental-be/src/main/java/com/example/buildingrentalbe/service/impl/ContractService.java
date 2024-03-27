package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.dto.ContractDto;
import com.example.buildingrentalbe.dto.IContractDto;
import com.example.buildingrentalbe.dto.IContractSearchDto;
import com.example.buildingrentalbe.dto.RequestContractDto;
import com.example.buildingrentalbe.model.Contract;
import com.example.buildingrentalbe.repository.ThamRepository.IContractRepository;
import com.example.buildingrentalbe.service.ThamService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }


    @Override
    public List<IContractDto> findContractByAccount(Integer idAccount) {
        return contractRepository.findContractByAccount(idAccount);
    }

    @Override
    public Page<IContractDto> findAllContract(Pageable pageable) {
        return contractRepository.findAllListContract(pageable);
    }

//    @Override
//    public Page<IContractDto> findAllPage(RequestContractDto requestContractDto, Pageable pageable) {
//        return contractRepository.findAllPage(requestContractDto,pageable);
//    }

    @Override
    public Page<IContractSearchDto> findPageByNameCustomer(String nameCustomer, Pageable pageable) {
        return contractRepository.findPageByNameCustomer("%"+nameCustomer+"%",pageable);
    }

    @Override
    public Page<IContractSearchDto> findPageByStatusContract(Integer statusContract, Pageable pageable) {
        return contractRepository.findPageByStatusContract(statusContract,pageable);
    }

    @Override
    public Page<IContractSearchDto> findPageByStatusContractAndNameCustomer(String nameCustomer, Integer statusContract, Pageable pageable) {
        return contractRepository.findPageByStatusContractAndNameCustomer(nameCustomer,statusContract,pageable);
    }

    @Override
    public Page<IContractSearchDto> findAllPageContract(Pageable pageable) {
        return contractRepository.findAllPageContract(pageable);
    }

    @Override
    public void save(ContractDto contract) {

        contractRepository.saveContract(contract);
    }


}
