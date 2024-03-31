package com.example.buildingrentalbe.controller.ThamController;

import com.example.buildingrentalbe.dto.ContractDto;
import com.example.buildingrentalbe.dto.IContractDto;
import com.example.buildingrentalbe.dto.IContractSearchDto;
import com.example.buildingrentalbe.dto.RequestContractDto;
import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.service.IPremisesService;
import com.example.buildingrentalbe.service.ThamService.annotation.DateRangeValidator;
import com.example.buildingrentalbe.service.ThamService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IPremisesService premisesService;


//    @GetMapping
//    public ResponseEntity<List<Contract>> showContract() {
//        List<Contract> contractList = contractService.findAll();
//        return new ResponseEntity<>(contractList, HttpStatus.OK);
//    }
//
//    @GetMapping("/listContract")
//    public ResponseEntity<?> showAllContract() {
//        Pageable pageable = PageRequest.of(0,5);
//        Page<IContractDto> contractDtoPage = contractService.findAllContract(pageable);
//        return new ResponseEntity<>(contractDtoPage, HttpStatus.OK);
//    }

    //search dto
    @PostMapping("")
    public ResponseEntity<Page<IContractDto>> showAllContract(@RequestBody RequestContractDto requestContractDto){
        Page<IContractDto> contractDtoPage = contractService.findAllPage(requestContractDto);
        return new ResponseEntity<>(contractDtoPage,HttpStatus.OK);
    }
//    @GetMapping("/search")
//    public ResponseEntity<?> getAllContract(
//            @RequestParam(value = "nameCustomer",required = false) String nameCustomer,
//            @RequestParam(value = "statusContract",required = false) Integer statusContract
//            ) {
//
//        Pageable pageable = PageRequest.of(0,5);
//        Page<IContractSearchDto> page = null;
//        if(nameCustomer != null && statusContract ==null){
//            page = contractService.findPageByNameCustomer(nameCustomer,pageable);
//        } else if (nameCustomer == null&& statusContract != null) {
//            page = contractService.findPageByStatusContract(statusContract,pageable);
//        } else if (nameCustomer != null) {
//            page = contractService.findPageByStatusContractAndNameCustomer(nameCustomer,statusContract,pageable);
//        }else {
//            page = contractService.findAllPageContract(pageable);
//        }
//
//        return new ResponseEntity<>(page, HttpStatus.OK);
//    }


    //là nhân viên
    @GetMapping("/employee")
    public ResponseEntity<List<IContractDto>> showYourOwnContract(){
    // lấy account
        Integer idAccount = 1;
        List<IContractDto> contractList = contractService.findContractByAccount(idAccount);
        return new ResponseEntity<>(contractList,HttpStatus.OK);
    }



    //thêm mới
    @PostMapping("/create")
    public ResponseEntity<?> createContract(@Validated @RequestBody ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(contractDto.getStartDate().isAfter(contractDto.getEndDate())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        contractService.save(contractDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
