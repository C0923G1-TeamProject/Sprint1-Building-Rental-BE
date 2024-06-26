package com.example.buildingrentalbe.service.contractService;

import com.example.buildingrentalbe.dto.*;
import com.example.buildingrentalbe.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();




    Page<IContractDto> findAllContract(Pageable pageable);

//    Page<IContractDto> findAllPage(RequestContractDto requestContractDto, Pageable pageable);

    Page<IContractSearchDto> findPageByNameCustomer(String nameCustomer, Pageable pageable);

    Page<IContractSearchDto> findPageByStatusContract(Integer statusContract, Pageable pageable);

    Page<IContractSearchDto> findPageByStatusContractAndNameCustomer(String nameCustomer, Integer statusContract, Pageable pageable);

    Page<IContractSearchDto> findAllPageContract(Pageable pageable);

    void save(ContractDto contract);


    Page<IContractDto> findAllPage(RequestContractDto requestContractDto);

    List<IContractDto> findContractByAccount(Integer idAccount);

    Page<IContractDto> findPageByAccount(RequestContractEmployeeDto requestContractEmployeeDto);
}
