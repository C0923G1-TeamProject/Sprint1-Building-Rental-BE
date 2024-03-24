package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.PremisesStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPremisesStatusRepository extends JpaRepository<PremisesStatus, Integer> {
}
