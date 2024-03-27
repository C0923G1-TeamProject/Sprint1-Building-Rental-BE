package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.TypePremises;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITypePremisesRepository extends JpaRepository<TypePremises, Integer> {
    @Query(value = "SELECT * FROM TypePremises p WHERE p.typePremises.name = :name", nativeQuery = true)
    public TypePremises findByNamePremises ();

}
