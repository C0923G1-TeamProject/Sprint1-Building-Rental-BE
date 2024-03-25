package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
