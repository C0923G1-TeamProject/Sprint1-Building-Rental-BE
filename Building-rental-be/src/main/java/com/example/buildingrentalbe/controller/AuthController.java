package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.config.security.secConfig.UserPrinciple;
import com.example.buildingrentalbe.config.security.service.JwtResponse;
import com.example.buildingrentalbe.config.security.service.JwtService;
import com.example.buildingrentalbe.config.security.service.UserService;
import com.example.buildingrentalbe.dto.AccountDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.model.Mail;
import com.example.buildingrentalbe.service.IEmployeeService;
import com.example.buildingrentalbe.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private IMailService iMailService;

    @Autowired
    private IEmployeeService iEmployeeService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountDto account) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentUser = userService.findByUsername(account.getUsername());
        System.out.println("kk " + currentUser);
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestHeader("Authorization") String bearToken) {
        String otp = generateFiveDigitInteger();
        // lay thong tin user
        String token = bearToken.substring(7);
        String username = jwtService.getUsernameFromJwtToken(token);
        Employee employee = iEmployeeService.findByUserNameAccount(username);
//        String email = employee.getEmail();
        String email = "nguyentukhanh2001@gmail.com";
        // gui mail
        Mail mail = new Mail();
        mail.setMailFrom("duyhoangc0923g1@gmail.com");
        mail.setMailTo(email);
        mail.setMailSubject("Khanh22");
        mail.setMailContent("Ma xac nhan cua tai khoan "+username+" la: " + otp);
        iMailService.sendEmail(mail);
        return ResponseEntity.ok("da gui thu");


    }


    @PostMapping("/confirm-otp")
    public ResponseEntity<?> confirmOtp(@RequestBody Boolean isValidOtp) {
        if(isValidOtp) {
            return ResponseEntity.ok("Thanh cong");
        } else {
            return new ResponseEntity<>("that bai",HttpStatus.NOT_ACCEPTABLE);
        }
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

    public String generateFiveDigitInteger() {
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(randomNumber);
    }
}
