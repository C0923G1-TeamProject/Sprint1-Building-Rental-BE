package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Premises;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface IPremisesRepository extends JpaRepository<Premises, Integer>, JpaSpecificationExecutor<Premises> {
    @Query(value = "select * from premises", nativeQuery = true)
    List<Premises> findAllPremises();



    @Query(value = "SELECT p.id, p.area, p.code, p.description, p.floor, p.price, p.cost, p.premises_status_id, p.id_type_premises, tp.name AS type_name, ps.name AS status_name " +
            "FROM premises AS p " +
            "JOIN type_premises AS tp ON p.id_type_premises = tp.id " +
            "JOIN premises_status AS ps ON p.premises_status_id = ps.id " +
            "WHERE p.id = :id", nativeQuery = true)
    Premises findById(int id);

    @Query(value = "select * from premises where code=:code", nativeQuery = true)
    Premises findPremisesByCode(String code);

    @Transactional
    @Modifying
    @Query(value = "UPDATE premises as p " +
            "SET p.code = :#{#premises.code}, p.floor = :#{#premises.floor}, p.area = :#{#premises.area}, " +
            "    p.description = :#{#premises.description}, p.price = :#{#premises.price}, p.cost = :#{#premises.cost}, " +
            "    p.id_type_premises = :#{#premises.typePremises.id}, p.premises_status_id = :#{#premises.premisesStatus.id} " +
            "WHERE p.id= :id", nativeQuery = true)
    void updatePremises(@Param("id") Integer id, @Param("premises") Premises premises);

    @Query(value = "SELECT p.id, p.area, p.code, p.description, p.floor, p.price, p.cost, p.premises_status_id, p.id_type_premises, tp.name AS type_name, ps.name AS status_name " +
            "FROM premises AS p " +
            "JOIN type_premises AS tp ON p.id_type_premises = tp.id " +
            "JOIN premises_status AS ps ON p.premises_status_id = ps.id " +
            "WHERE p.premises_status_id = 1", nativeQuery = true)
    List<Premises> findByStatus();
}
