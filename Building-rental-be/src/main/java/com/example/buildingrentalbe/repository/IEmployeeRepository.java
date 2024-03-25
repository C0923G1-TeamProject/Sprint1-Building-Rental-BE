package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.dto.IInformationDto;
import com.example.buildingrentalbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
//    @Query(value = "select e.code as `code`," +
//            "e.date as `date`," +
//            "e.address as `address`," +
//            "e.name as `name`," +
//            "e.department as `department`," +
//            "e.email as `email`," +
//            "e.gender as `gender`," +
//            "e.phone_number as `phoneNumber`," +
//            "e.start_date as `startDate` " +
//            "e.id as `id` " +
//            " from employee e left join account as acc on e.id = acc.id_employee " +
//            "where acc.username = :accountName", nativeQuery = true)
//    List<IInformationDto> personalInformation(@Param("accountName") String accountName);
//
//    @Query(value = "update account" +
//            "set account.password = :password " +
//            "where account.id = :id ", nativeQuery = true)
//    void changedPassword(@Param("id") Integer id, @Param("password") String password);

}
