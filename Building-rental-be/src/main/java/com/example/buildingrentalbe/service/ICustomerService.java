package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> getList(Pageable pageable);

    void save(Customer customer);

    void delete(Customer customer);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Page<Customer> findByEmailContaining(String email, Pageable pageable);

    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

    int countByEmail(String email);

    int countByCard(String card);

    int countByPhoneNumber(String phone);

    List<Customer> getAllList();

    Customer findById(Integer id);
}
