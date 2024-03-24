package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Premises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPremisesRepository extends JpaRepository<Premises, Integer> {
    @Query(value = "select * from premises", nativeQuery = true)
    List<Premises> findAllPremises();


}
