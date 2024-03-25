package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Premises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPremisesRepository extends JpaRepository<Premises, Integer>, JpaSpecificationExecutor<Premises> {
    @Query(value = "select * from premises", nativeQuery = true)
    List<Premises> findAllPremises();

    @Query(value = "select * from premises where id=:id", nativeQuery = true)
    Premises findById(int id);

    @Query(value = "select * from premises where code=:code", nativeQuery = true)
    Premises findPremisesByCode(String code);

}
