package com.example.buildingrentalbe.repository.ThamRepository;

import com.example.buildingrentalbe.dto.*;
import com.example.buildingrentalbe.model.Contract;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {



    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Get list contract by Admin
     */
    @Query(value = " select ct.id as id, ct.code as code, ct.startDate as startDate, ct.endDate as endDate, ct.deposit as deposit, " +
            " ct.content as content, ct.paymentTerm as paymentTerm, cs as contractStatus, ac as account, pr as premises, c as customer" +
            " from Contract ct " +
            " join ContractStatus cs on ct.contractStatus.id = cs.id " +
            " join Account ac on ct.account.id = ac.id" +
            " join Premises pr on ct.premises.id = pr.id" +
            " join Customer c on ct.customer.id = c.id")
    Page<IContractDto> findAllListContract(Pageable pageable);

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Get list contract and search nameCustomer
     */
    @Query(value = " select ct.id as idContract, ct.code as code, ct.start_date as startDate, ct.end_date as endDate, ct.deposit as deposit, " +
            " ct.content as content, ct.payment_term as paymentTerm, cs.name as contractStatus, ac.username as nameAccount, pr.code as codePremises, c.name as nameCustomer" +
            " from contract ct " +
            " join contract_status cs on ct.id_contract_status = cs.id " +
            " join account ac on ct.id_account = ac.id" +
            " join premises pr on ct.id_premises = pr.id" +
            " join customer c on ct.id_customer = c.id" +
            " where c.name like :nameCustomer",nativeQuery = true)
    Page<IContractSearchDto> findPageByNameCustomer(@Param("nameCustomer") String nameCustomer, Pageable pageable);

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Get list contract and search statusContract
     */
    @Query(value = " select ct.id as idContract, ct.code as code, ct.start_date as startDate, ct.end_date as endDate, ct.deposit as deposit, " +
            " ct.content as content, ct.payment_term as paymentTerm, cs.name as contractStatus, ac.username as nameAccount, pr.code as codePremises, c.name as nameCustomer" +
            " from contract ct " +
            " join contract_status cs on ct.id_contract_status = cs.id " +
            " join account ac on ct.id_account = ac.id" +
            " join premises pr on ct.id_premises = pr.id" +
            " join customer c on ct.id_customer = c.id" +
            " where cs.id = :statusContract",nativeQuery = true)
    Page<IContractSearchDto> findPageByStatusContract(Integer statusContract, Pageable pageable);

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Get list contract and search statusContract and nameCustomer
     */
    @Query(value = " select ct.id as idContract, ct.code as code, ct.start_date as startDate, ct.end_date as endDate, ct.deposit as deposit, " +
            " ct.content as content, ct.payment_term as paymentTerm, cs.name as contractStatus, ac.username as nameAccount, pr.code as codePremises, c.name as nameCustomer" +
            " from contract ct " +
            " join contract_status cs on ct.id_contract_status = cs.id " +
            " join account ac on ct.id_account = ac.id" +
            " join premises pr on ct.id_premises = pr.id" +
            " join customer c on ct.id_customer = c.id" +
            " where c.name like %:nameCustomer% and cs.id = :statusContract",nativeQuery = true)
    Page<IContractSearchDto> findPageByStatusContractAndNameCustomer(String nameCustomer, Integer statusContract, Pageable pageable);

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Get list contract
     */
    @Query(value = " select ct.id as idContract, ct.code as code, ct.start_date as startDate, ct.end_date as endDate, ct.deposit as deposit, " +
            " ct.content as content, ct.payment_term as paymentTerm, cs.name as contractStatus, ac.username as nameAccount, pr.code as codePremises, c.name as nameCustomer" +
            " from contract ct " +
            " join contract_status cs on ct.id_contract_status = cs.id " +
            " join account ac on ct.id_account = ac.id" +
            " join premises pr on ct.id_premises = pr.id" +
            " join customer c on ct.id_customer = c.id" ,nativeQuery = true)
    Page<IContractSearchDto> findAllPageContract(Pageable pageable);

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Create new contract
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO contract (code, content, deposit,end_date, payment_term, start_date, id_account, id_contract_status, id_customer, id_premises) " +
            "VALUES (:#{#contract.code},:#{#contract.content},:#{#contract.deposit},:#{#contract.endDate},:#{#contract.paymentTerm},:#{#contract.startDate},:#{#contract.idAccount}, " +
            ":#{#contract.idContractStatus},:#{#contract.idCustomer},:#{#contract.idPremises} )",nativeQuery = true)
    void saveContract(@Param("contract") ContractDto contract);


    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Select page has param is a requestContractDto
     */
    @Query(value = " select ct.id as id, ct.code as code, ct.startDate as startDate, ct.endDate as endDate, ct.deposit as deposit, e.id as idEmployee,e.name as nameEmployee," +
            " ct.content as content, ct.paymentTerm as paymentTerm, cs as contractStatus, ac as account, pr as premises, c as customer" +
            " from Contract ct " +
            " join ContractStatus cs on ct.contractStatus.id = cs.id " +
            " join Account ac on ct.account.id = ac.id" +
            " join Premises pr on ct.premises.id = pr.id" +
            " join Customer c on ct.customer.id = c.id"+
            " join Employee e on ac.employee.id = e.id"+
            " where c.name like concat('%',:#{#requestContractDto.nameCustomer},'%') " +
            " and e.name like concat('%',:#{#requestContractDto.nameEmployee},'%') " +
            " and (cs.id = :#{#requestContractDto.idContractStatus} or :#{#requestContractDto.idContractStatus} = -1)" +
            " ORDER BY ct.id")
    Page<IContractDto> findAllPage(@Param("requestContractDto") RequestContractDto requestContractDto, Pageable pageable);


    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Get list contract by Employee
     */
    @Query(value = " select ct.id as id, ct.code as code, ct.startDate as startDate, ct.endDate as endDate, ct.deposit as deposit, e.id as idEmployee,e.name as nameEmployee," +
            " ct.content as content, ct.paymentTerm as paymentTerm, cs as contractStatus, ac as account, pr as premises, c as customer" +
            " from Contract ct " +
            " join ContractStatus cs on ct.contractStatus.id = cs.id " +
            " join Account ac on ct.account.id = ac.id" +
            " join Premises pr on ct.premises.id = pr.id" +
            " join Customer c on ct.customer.id = c.id"+
            " join Employee e on ac.employee.id = e.id" +
            " where ac.id = :#{#idAccount}"
            )
    List<IContractDto> findContractByAccount( @Param("idAccount")Integer idAccount);

    @Query(value = " select ct.id as id, ct.code as code, ct.startDate as startDate, ct.endDate as endDate, ct.deposit as deposit, e.id as idEmployee,e.name as nameEmployee," +
            " ct.content as content, ct.paymentTerm as paymentTerm, cs as contractStatus, ac as account, pr as premises, c as customer" +
            " from Contract ct " +
            " join ContractStatus cs on ct.contractStatus.id = cs.id " +
            " join Account ac on ct.account.id = ac.id" +
            " join Premises pr on ct.premises.id = pr.id" +
            " join Customer c on ct.customer.id = c.id"+
            " join Employee e on ac.employee.id = e.id"+
            " where c.name like concat('%',:#{#requestContractEmployeeDto.nameCustomer},'%') " +
            " and e.name like concat('%',:#{#requestContractEmployeeDto.nameEmployee},'%') " +
            "and (cs.id = :#{#requestContractEmployeeDto.idContractStatus} or :#{#requestContractEmployeeDto.idContractStatus} = -1)" +
            " and ac.id = :#{#requestContractEmployeeDto.idAccount}")
    Page<IContractDto> findPageByAccount(@Param("requestContractEmployeeDto") RequestContractEmployeeDto requestContractEmployeeDto, Pageable pageable);

}
