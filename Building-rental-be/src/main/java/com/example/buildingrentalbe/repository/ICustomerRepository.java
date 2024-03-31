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

    @Query(value = "select count(*) from customer where email = ?1", nativeQuery = true)
    int countByEmail(String email);
    @Query(value = "select count(*) from customer where card = ?1", nativeQuery = true)
    int countByCard(String card);
    @Query(value = "select count(*) from customer where phone_number = ?1", nativeQuery = true)
    int countByPhoneNumber(String phone);
}
