package com.example.buildingrentalbe.controller.ThamController;

import com.example.buildingrentalbe.config.security.service.JwtService;
import com.example.buildingrentalbe.dto.*;
import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.service.IAccountService;
import com.example.buildingrentalbe.service.IEmployeeService;
import com.example.buildingrentalbe.service.IPremisesService;
import com.example.buildingrentalbe.service.ThamService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IAccountService accountService;


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



    //là nhân viên
    @PostMapping("/employee")
    public ResponseEntity<List<IContractDto>> showYourOwnContract(@RequestHeader("Authorization")String token){
        // lấy account
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        Integer idAccount = accountService.findAccountByUsername(username).getId();
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
    @PostMapping("/getInfo")
    public ResponseEntity<?> getInfo(@RequestHeader("Authorization")String token){
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        Employee employee = employeeService.findByUserNameAccount(username);
        String name = employee.getName();
        Integer idAccount = accountService.findAccountByUsername(username).getId();
        InfoAccountContractDto infoAccountContractDto = new InfoAccountContractDto(name,idAccount);
        return new ResponseEntity<>(infoAccountContractDto,HttpStatus.OK);

    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<Employee> getAllEmployee(String username){
        Employee employee = employeeService.findByUserNameAccount(username);
        return new ResponseEntity<>(employee,HttpStatus.OK);

    }


}
