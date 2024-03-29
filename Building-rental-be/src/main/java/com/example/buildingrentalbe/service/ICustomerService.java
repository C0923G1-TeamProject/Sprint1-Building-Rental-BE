package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> getList(Pageable pageable);

    void save(Customer customer);

    void delete(Customer customer);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Page<Customer> findByEmailContaining(String email, Pageable pageable);

    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);
}
