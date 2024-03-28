package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.PremisesStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPremisesStatusRepository extends JpaRepository<PremisesStatus, Integer> {
}
