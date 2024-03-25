package com.example.buildingrentalbe.repository.ThamRepository;

import com.example.buildingrentalbe.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT * FROM contract",nativeQuery = true)
    List<Contract> findAllContract();
    @Query(value = "SELECT * FROM contract where id_account = :idAccount", nativeQuery = true)
    List<Contract> findContractByAccount(@Param("idAccount") Integer idAccount);
}
