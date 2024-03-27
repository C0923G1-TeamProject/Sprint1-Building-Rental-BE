package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select employee.* from employee join account on employee.id = account.id_employee where account.username = :username", nativeQuery = true)
    public Employee findByUsernameAccount(@Param("username")String username);
}
