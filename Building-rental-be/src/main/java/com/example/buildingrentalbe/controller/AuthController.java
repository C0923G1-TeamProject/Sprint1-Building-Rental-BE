package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        return ResponseEntity.ok("Dang nhap thanh cong");
    }
}
