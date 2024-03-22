package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
