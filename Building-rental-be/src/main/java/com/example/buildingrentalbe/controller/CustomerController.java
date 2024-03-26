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

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService service;

    @GetMapping("/show")
    public ResponseEntity<?> show(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String card,
                                  @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers;
        if (name != null && !name.isEmpty() && (card == null || card.isEmpty())) {
            customers = service.findByNameContaining(name, pageable);
        } else if (card != null && !card.isEmpty() && (name == null || name.isEmpty())) {
            customers = service.findByCardContaining(card, pageable);
        } else if (name != null && !name.isEmpty()) {
            customers = service.findByNameContainingAndCardContaining(name, card, pageable);
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
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        service.save(customer);
        return ResponseEntity.ok("Thêm thành công");
    }
}
