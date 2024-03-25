package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService service;
    @GetMapping("")
    public ResponseEntity<?> show(@PageableDefault(value = 5)Pageable pageable){
        Page<Customer> customers = service.getList(pageable);
       return ResponseEntity.ok(customers);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Customer customer){
        service.save(customer);
        return ResponseEntity.ok("Thêm thành công");
    }
}
