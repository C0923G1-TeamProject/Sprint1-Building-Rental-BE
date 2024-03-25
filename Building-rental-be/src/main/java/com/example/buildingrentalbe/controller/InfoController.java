package com.example.buildingrentalbe.controller;


import com.example.buildingrentalbe.dto.InformationDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.service.IAccountService;
import com.example.buildingrentalbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/information")
public class InfoController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/account/{id}")
    public ResponseEntity<?> informationAccountUser(@PathVariable Integer id) {
        Account account = this.iAccountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


//    Khi nào có security thì mở - update password
//    @PostMapping("/changed-password")
//    public ResponseEntity<?> changePassword(@RequestBody InformationDto informationDto) {
//        String username = "vitkt";
//        Account account = this.iAccountService.findAccountByUsername(username);
//        System.out.println(account);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        if (bCryptPasswordEncoder.matches(informationDto.getCurrentPassword(), account.getPassword())) {
//            // check new pass vs confrm
//            if (informationDto.getNewPassword().equals(informationDto.getConfirmNewPassword())) {
//                this.iAccountService.changePassword(bCryptPasswordEncoder.encode(informationDto.getNewPassword()), account.getId());
//            } else {
//                return new ResponseEntity<>("Code ngu",HttpStatus.BAD_REQUEST);
//            }
//        } else {
//            return new ResponseEntity<>("Code ngu",HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PostMapping("/updateInformation")
//    public ResponseEntity<?> updateInformation(){
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
