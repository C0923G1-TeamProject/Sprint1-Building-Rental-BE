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

//    @Override
//    public Page<Customer> findByNameCustomerContaining(String name, Pageable pageable) {
//        return repository.findByNameCustomerContaining(name, pageable);
//    }
}
