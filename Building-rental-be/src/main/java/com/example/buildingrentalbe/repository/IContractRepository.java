package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
