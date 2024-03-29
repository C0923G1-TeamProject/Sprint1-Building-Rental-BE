package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Page<Customer> findByEmailContaining(String email, Pageable pageable);

    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

}
