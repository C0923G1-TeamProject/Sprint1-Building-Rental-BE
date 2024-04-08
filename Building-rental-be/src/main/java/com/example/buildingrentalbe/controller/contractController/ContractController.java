package com.example.buildingrentalbe.controller.contractController;

import com.example.buildingrentalbe.config.security.service.JwtService;
import com.example.buildingrentalbe.dto.*;
import com.example.buildingrentalbe.model.Customer;
import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.model.Mail;
import com.example.buildingrentalbe.service.*;
import com.example.buildingrentalbe.service.contractService.IContractService;
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

    @Autowired
    private IMailService mailService;
    @Autowired
    private ICustomerService customerService;


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
    public ResponseEntity<Object> createContract(@Validated @RequestBody ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(contractDto.getStartDate().isAfter(contractDto.getEndDate())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        contractService.save(contractDto);
        Customer customer = customerService.findById(contractDto.getIdCustomer());
        Mail mail = new Mail();
        mail.setMailSubject("[Xác nhận tạo hợp đồng]");
        mail.setMailContent("Chào bạn, "+customer.getName()+"chúng tôi đã tạo hợp đồng thành công." +
                "Hợp đồng sẽ bắt đầu vào ngày"+contractDto.getStartDate() +"mong bạn sắp xếp thời gian đến văn phòng chúng tôi để ký");
        mail.setMailFrom("tranthihongtham1604@gmail.com");
        mail.setMailTo("thamtth98@gmail.com");
        mail.setMailContent("<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div style=\"font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\">\n" +
                "        <div style=\"margin:20px auto;width:70%;padding:20px 0\">\n" +
                "            <div\n" +
                "                style=\"border-bottom:1px solid #eee; display: flex; justify-content: center; background: #e9c9a6; align-items: center\">\n" +
                "                <a href=\"\" style=\"font-size:1.4em;color: #63101094;text-decoration:none;font-weight:600;justify-content: center;\n" +
                "    align-items: center;\">DIAMOND TIME</a>\n" +
                "            </div>\n" +
                "\n" +
                "            <p style=\"font-size:1.2em; color: black;\">Xin chào khách hàng "+customer.getName()+"!</p>\n" +
                "            <p style=\"font-size:1.2em; color: black;\">Chúng tôi đã tạo thành công hợp đồng thuê mặt bằng cho bạn.</p>\n" +
                "            <p style=\"font-size:1.2em; color: black;\">Mã hợp đồng là: " +contractDto.getCode()+"</p>\n" +
                "<p style=\"font-size:1.2em; color: black;\">Hợp đồng sẽ bắt đầu vào ngày: "+contractDto.getStartDate()+" và kết thúc vào ngày: "+contractDto.getEndDate()+"</p> \n"+

                "<p style=\"font-size:1.2em; color: black;\">Nếu có thắc mắc mời bạn liên hệ với chúng tôi để được giải đáp và" +
                " có trải nghiệm tốt nhất.</p> \n"+
                "<p style=\"font-size:1.2em; color: black;\">Xin trân trọng cảm ơn! "+
                "            <div style=\"float:left;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">\n" +
                "                <p>Diamond time</p>\n" +
                "                <p>15 Thái Phiên, phường Phước Ninh, quận Hải Châu, Đà Nẵng</p>\n" +
                "                <p>Việt Nam</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>");
        mailService.sendEmail(mail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/getInfo")
    public ResponseEntity<InfoAccountContractDto> getInfo(@RequestHeader("Authorization")String token){
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

    @PostMapping("/accountEmployee")
    public ResponseEntity<Page<IContractDto>> getContractByUser(@RequestBody RequestContractEmployeeDto requestContractEmployeeDto){
        Page<IContractDto> contractDtoPage = contractService.findPageByAccount(requestContractEmployeeDto);
        return new ResponseEntity<>(contractDtoPage,HttpStatus.OK);
    }




}
