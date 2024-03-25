package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.model.PremisesStatus;
import com.example.buildingrentalbe.model.TypePremises;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPremisesRepository extends JpaRepository<Premises, Integer>, JpaSpecificationExecutor<Premises> {
    @Query(value = "select * from premises", nativeQuery = true)
    List<Premises> findAllPremises();

    @Query(value = "select * from premises where id=:id", nativeQuery = true)
    Premises findById(int id);

    @Query(value = "select * from premises where code=:code", nativeQuery = true)
    Premises findPremisesByCode(String code);

    @Transactional
    @Modifying
    @Query(value = "UPDATE premises p " +
            "SET p.code = :code, p.floor = :floor, p.area = :area, " +
            "    p.description = :description, p.price = :price, p.cost = :cost, " +
            "    p.id_type_premises = :typePremisesId, p.id_premises_status = :premisesStatusId " +
            "WHERE p.id = :id", nativeQuery = true)
    void updatePremises(@Param("id") Integer id,
                        @Param("code") String code,
                        @Param("floor") Integer floor,
                        @Param("area") Float area,
                        @Param("description") String description,
                        @Param("price") Long price,
                        @Param("cost") Long cost,
                        @Param("typePremisesId") Integer typePremisesId,
                        @Param("premisesStatusId") Integer premisesStatusId);
}
