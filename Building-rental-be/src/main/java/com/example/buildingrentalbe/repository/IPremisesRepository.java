package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Premises;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPremisesRepository extends JpaRepository<Premises, Integer>, JpaSpecificationExecutor<Premises> {
    @Query(value = "select * from premises where  id_type_premises like :searchByTypePremises", nativeQuery = true)
    Page<Premises> search(@Param("searchByTypePremises") String typePremises, Pageable pageable);

    @Query(value = "select * from  premises  where  id_type_premises = :id_type_premises", nativeQuery = true)
    Page<Premises> searchWithTypePremises(@Param("id_type_premises") int PremisesId, Pageable pageable);

    @Query(value = "select * from premises where id=:id", nativeQuery = true)
    Premises findById(int id);

    @Query(value = "select * from premises where code=:code", nativeQuery = true)
    Premises findPremisesByCode(String code);

}
