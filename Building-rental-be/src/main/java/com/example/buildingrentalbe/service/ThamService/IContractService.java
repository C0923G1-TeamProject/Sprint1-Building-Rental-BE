package com.example.buildingrentalbe.service.ThamService;

import com.example.buildingrentalbe.dto.ContractDto;
import com.example.buildingrentalbe.dto.IContractDto;
import com.example.buildingrentalbe.dto.IContractSearchDto;
import com.example.buildingrentalbe.dto.RequestContractDto;
import com.example.buildingrentalbe.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();


    List<IContractDto> findContractByAccount(Integer idAccount);

    Page<IContractDto> findAllContract(Pageable pageable);

//    Page<IContractDto> findAllPage(RequestContractDto requestContractDto, Pageable pageable);

    Page<IContractSearchDto> findPageByNameCustomer(String nameCustomer, Pageable pageable);

    Page<IContractSearchDto> findPageByStatusContract(Integer statusContract, Pageable pageable);

    Page<IContractSearchDto> findPageByStatusContractAndNameCustomer(String nameCustomer, Integer statusContract, Pageable pageable);

    Page<IContractSearchDto> findAllPageContract(Pageable pageable);

    void save(ContractDto contract);


    Page<IContractDto> findAllPage(RequestContractDto requestContractDto);
}
