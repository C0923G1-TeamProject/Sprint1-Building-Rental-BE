package com.example.buildingrentalbe.controller.ThamController;

import com.example.buildingrentalbe.dto.IContractStatusDto;
import com.example.buildingrentalbe.model.Contract;
import com.example.buildingrentalbe.model.ContractStatus;
import com.example.buildingrentalbe.service.ThamService.IContractStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/contractStatus")
public class ContractStatusController {
    @Autowired
    private IContractStatusService contractStatusService;
    @GetMapping
    public ResponseEntity<List<ContractStatus>> showContractStatus() {
        List<ContractStatus> contractStatusList = contractStatusService.findAll();
        return new ResponseEntity<>(contractStatusList, HttpStatus.OK);
    }

    @GetMapping("/pageStatus")
    public ResponseEntity<?> getContractStatus() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<IContractStatusDto> contractStatusList = this.contractStatusService.getAll(pageable);
        return new ResponseEntity<>(contractStatusList, HttpStatus.OK);
    }
}
