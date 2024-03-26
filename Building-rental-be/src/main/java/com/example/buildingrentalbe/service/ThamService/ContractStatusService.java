package com.example.buildingrentalbe.service.ThamService;

import com.example.buildingrentalbe.dto.IContractStatusDto;
import com.example.buildingrentalbe.model.ContractStatus;
import com.example.buildingrentalbe.repository.ThamRepository.IContractStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractStatusService implements IContractStatusService{
    @Autowired
    private IContractStatusRepository contractStatusRepository;
    @Override
    public List<ContractStatus> findAll() {
        return contractStatusRepository.findAllStatus();
    }

    @Override
    public Page<IContractStatusDto> getAll(Pageable pageable) {
        return this.contractStatusRepository.getAll(pageable);
    }
}
