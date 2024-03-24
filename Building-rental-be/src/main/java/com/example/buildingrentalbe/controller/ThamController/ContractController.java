package com.example.buildingrentalbe.controller.ThamController;

import com.example.buildingrentalbe.model.Contract;
import com.example.buildingrentalbe.service.ThamService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @GetMapping
    public ResponseEntity<List<Contract>> showContract() {
        List<Contract> contractList = contractService.findAll();
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }
//    là nhân viên
    @GetMapping("/employee")
    public ResponseEntity<List<Contract>> showYourOwnContract(){
//        lấy account
        Integer idAccount = 1;
        List<Contract> contractList = contractService.findContractByAccount(idAccount);
        return new ResponseEntity<>(contractList,HttpStatus.OK);
    }


}
