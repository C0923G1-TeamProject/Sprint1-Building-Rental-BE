package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.repository.ICustomerRepository;
import com.example.buildingrentalbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public Page<Customer> getList(Pageable pageable) {
        return repository.findAllCustomer(pageable);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        repository.delete(customer);
    }

    @Override
    public Page<Customer> findByNameContaining(String name, Pageable pageable) {
        return repository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findByCardContaining(String card, Pageable pageable) {
        return repository.findByCardContaining(card, pageable);
    }

    @Override
    public Page<Customer> findByNameContainingAndCardContaining(String name, String card, Pageable pageable) {
        return repository.findByNameContainingAndCardContaining(name, card, pageable);
    }

}
