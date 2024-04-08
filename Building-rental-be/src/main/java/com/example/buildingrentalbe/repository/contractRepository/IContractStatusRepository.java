package com.example.buildingrentalbe.repository.contractRepository;

import com.example.buildingrentalbe.dto.IContractStatusDto;
import com.example.buildingrentalbe.model.ContractStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractStatusRepository extends JpaRepository<ContractStatus,Integer> {
    @Query(value = "select * from contract_status",nativeQuery = true)
    List<ContractStatus> findAllStatus();


    @Query(value = "select cs.id as id, cs.name as name from contract_status cs",nativeQuery = true)
    Page<IContractStatusDto> getAll(Pageable pageable);
}
