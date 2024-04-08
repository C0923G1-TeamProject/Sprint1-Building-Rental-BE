package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.repository.ICustomerRepository;
import com.example.buildingrentalbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<Customer> findByEmailContaining(String card, Pageable pageable) {
        return repository.findByEmailContaining(card, pageable);
    }

    @Override
    public Page<Customer> findByNameContainingAndEmailContaining(String name, String card, Pageable pageable) {
        return repository.findByNameContainingAndEmailContaining(name, card, pageable);
    }

    @Override
    public int countByEmail(String email) {
        return repository.countByEmail(email);
    }

    @Override
    public int countByCard(String card) {
        return repository.countByCard(card);
    }

    @Override
    public int countByPhoneNumber(String phone) {
        return repository.countByPhoneNumber(phone);
    }

    @Override
    public List<Customer> getAllList() {
        return repository.getAllList();
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

}
