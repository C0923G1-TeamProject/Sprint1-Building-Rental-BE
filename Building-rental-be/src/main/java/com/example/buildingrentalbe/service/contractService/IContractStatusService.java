package com.example.buildingrentalbe.service.contractService;

import com.example.buildingrentalbe.dto.IContractStatusDto;
import com.example.buildingrentalbe.model.ContractStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractStatusService {
    List<ContractStatus> findAll();

    Page<IContractStatusDto> getAll(Pageable pageable);
}
