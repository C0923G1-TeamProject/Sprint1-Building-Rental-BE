package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.config.security.service.JwtResponse;
import com.example.buildingrentalbe.config.security.service.JwtService;
import com.example.buildingrentalbe.config.security.service.UserService;
import com.example.buildingrentalbe.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        String a = "aa";
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentUser = userService.findByUsername(account.getUsername());
        System.out.println("kk " + currentUser);
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/getInfo")
    public ResponseEntity<?> getInfo(@RequestHeader("Authorization")String token) {
        String newToken = token.substring(7);
        String userName = jwtService.getUsernameFromJwtToken(newToken);
        System.out.println(userName);
        return ResponseEntity.ok(userName);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutSuccessful(@RequestHeader("Authorization")String token){
        String newToken = token.substring(7);
        jwtService.addToBlackList(newToken);
        return ResponseEntity.ok("ok dang xuat");
    }




    @GetMapping("/k")
    public ResponseEntity<?> k(@RequestBody Account account) {
        return ResponseEntity.ok("trang chu");

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/ad")
    public ResponseEntity<?> kad(@RequestBody Account account) {
        return ResponseEntity.ok("trang ad");

    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/onlyUser")
    public ResponseEntity<?> uu(@RequestBody Account account) {
        return ResponseEntity.ok("trang user");

    }
}
