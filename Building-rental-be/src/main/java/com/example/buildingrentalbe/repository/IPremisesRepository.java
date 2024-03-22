package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Premises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPremisesRepository extends JpaRepository<Premises, Integer> {
}
