package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.dto.ContractDto;
import com.example.buildingrentalbe.dto.IContractDto;
import com.example.buildingrentalbe.dto.IContractSearchDto;
import com.example.buildingrentalbe.dto.RequestContractDto;
import com.example.buildingrentalbe.model.Contract;
import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.model.PremisesStatus;
import com.example.buildingrentalbe.repository.IPremisesRepository;
import com.example.buildingrentalbe.repository.ThamRepository.IContractRepository;
import com.example.buildingrentalbe.service.ThamService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IPremisesRepository premisesRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
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

    //tự động set mã hợp đồng tăng dần
    public String createCodeContract(){
        Long nextCode = contractRepository.count() + 1;
        return "HD-" + String.format("%04d",nextCode);
    }


    @Override
    public void save(ContractDto contract) {
        Premises premises = premisesRepository.findById(contract.getIdPremises()).orElse(null);
        assert premises != null;
        premises.setPremisesStatus(new PremisesStatus(2,"Đã bàn giao"));
        premisesRepository.updatePremises(premises.getId(), premises);

        contract.setCode(createCodeContract());
        contract.setIdContractStatus(1);
        contractRepository.saveContract(contract);
    }

    @Override
    public Page<IContractDto> findAllPage(RequestContractDto requestContractDto) {
        Pageable pageable = PageRequest.of(requestContractDto.getPage(), requestContractDto.getSize());
        return contractRepository.findAllPage(requestContractDto,pageable);
    }

    @Override
    public List<IContractDto> findContractByAccount(Integer idAccount) {
        return contractRepository.findContractByAccount(idAccount);
    }


}
