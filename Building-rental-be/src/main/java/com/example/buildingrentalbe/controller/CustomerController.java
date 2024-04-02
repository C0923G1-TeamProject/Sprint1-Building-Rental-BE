package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.dto.CustomerDto;
import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService service;

    @GetMapping("/show")
    public ResponseEntity<?> show(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String email,
                                  @PageableDefault(value = 6) Pageable pageable) {
        Page<Customer> customers;
        if (name != null && !name.isEmpty() && (email == null || email.isEmpty())) {
            customers = service.findByNameContaining(name, pageable);
        } else if (email != null && !email.isEmpty() && (name == null || name.isEmpty())) {
            customers = service.findByEmailContaining(email, pageable);
        } else if (name != null && !name.isEmpty()) {
            customers = service.findByNameContainingAndEmailContaining(name, email, pageable);
        } else {
            customers = service.getList(pageable);
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        if (service.countByEmail(customerDto.getEmail()) > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("email");
        }
        if (service.countByCard(customerDto.getCard()) > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("card");
        }
        if (service.countByPhoneNumber(customerDto.getPhoneNumber()) > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("phone");
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        service.save(customer);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers (){
        List<Customer> newList = service.getAllList();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }
}
