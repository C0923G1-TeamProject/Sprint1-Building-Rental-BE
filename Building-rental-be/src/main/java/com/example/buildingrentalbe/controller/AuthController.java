package com.example.buildingrentalbe.controller;


import com.example.buildingrentalbe.config.security.service.JwtResponse;
import com.example.buildingrentalbe.config.security.service.JwtService;
import com.example.buildingrentalbe.config.security.service.LoginResponse;
import com.example.buildingrentalbe.config.security.service.UserService;
import com.example.buildingrentalbe.dto.AccountDto;
import com.example.buildingrentalbe.dto.AccountInfoDto;
import com.example.buildingrentalbe.model.Account;
import com.example.buildingrentalbe.model.Employee;
import com.example.buildingrentalbe.model.Mail;
import com.example.buildingrentalbe.service.IAccountService;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;



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

    @Autowired
    private IAccountService iAccountService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AccountDto account) {
        boolean isVisited = false;

        if (account.getIsVisited() != null) {
            String arr = account.getIsVisited();
            String[] listVisited = arr.split(",");


            Integer idAccount = iAccountService.findAccountByUsername(account.getUsername()).getId();

            for (int i = 0; i < listVisited.length; i++) {
                if (idAccount == Integer.valueOf(listVisited[i])) {
                    isVisited = true;
                    break;
                }
            }
        }


        Account accountDtoDB = iAccountService.findAccountByUsername(account.getUsername());
        Employee employee = iEmployeeService.findByUserNameAccount(account.getUsername());


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Boolean isValidPass = bCryptPasswordEncoder.matches(account.getPassword(), accountDtoDB.getPassword());
        if (isValidPass && isVisited) {
            Authentication authentication
                    = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Account currentUser = userService.findByUsername(account.getUsername());

            System.out.println("kk " + currentUser);

            return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), employee.getName(), userDetails.getAuthorities(), "", "direct-access", ""));
        } else if (isValidPass) {
            String otp = generateFiveDigitInteger();
            // gui mail
            Mail mail = new Mail();
            mail.setMailFrom("duyhoangc0923g1@gmail.com");
            mail.setMailTo(employee.getEmail());
            mail.setMailSubject("Xác nhận đăng nhập tại Diamond Time");

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
                    "        <div style=\"margin:50px auto;width:70%;padding:20px 0\">\n" +
                    "            <div\n" +
                    "                style=\"border-bottom:1px solid #eee; display: flex; justify-content: center; background: #e9c9a6; align-items: center\">\n" +
                    "                <a href=\"\" style=\"font-size:1.4em;color: #63101094;text-decoration:none;font-weight:600;justify-content: center;\n" +
                    "    align-items: center;\">DIAMOND TIME</a>\n" +
                    "            </div>\n" +
                    "\n" +
                    "            <p style=\"font-size:1.2em; color: black;\">Xin chào "+employee.getName()+"</p>\n" +
                    "            <p style=\"font-size:1.2em; color: black;\">Hãy nhập mã bên dưới để xác nhận đăng nhập hệ thống cho thiết bị mới</p>\n" +
                    "            <h2\n" +
                    "                style=\"background: #e4a25acf;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">\n" +
                    "                "+otp+"</h2>\n" +
                    "            <p style=\"font-size:1.1em; color: black;\">Vui lòng không chia sẻ mã này cho người bên ngoài,<br />Cảm ơn</p>\n" +
                    "            <hr style=\"border:none;border-top:1px solid #eee\" />\n" +
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
            iMailService.sendEmail(mail);
            return ResponseEntity.ok(new LoginResponse(otp, "redirect-to-otp", employee.getEmail()));

        } else {
            return ResponseEntity.ok(new LoginResponse("", "wrong-password", ""));
        }
    }

    @PostMapping("/login-otp")
    public ResponseEntity<Object> loginOtp(@RequestBody AccountDto account) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentUser = userService.findByUsername(account.getUsername());
        System.out.println("kk " + currentUser);
        Employee employee = iEmployeeService.findByUserNameAccount(account.getUsername());
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), employee.getName(), userDetails.getAuthorities(), "", "", ""));
    }


    @PostMapping("/resend-otp")
    public ResponseEntity<Object> sendOtp(@RequestBody AccountDto account) {
        String otp = generateFiveDigitInteger();
        // lay thong tin user
        Account accountDtoDB = iAccountService.findAccountByUsername(account.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(account.getPassword(), accountDtoDB.getPassword())) {
            Employee employee = iEmployeeService.findByUserNameAccount(account.getUsername());
            String email = employee.getEmail();
            // gui mail
            Mail mail = new Mail();
            mail.setMailFrom("duyhoangc0923g1@gmail.com");
            mail.setMailTo(email);
            mail.setMailSubject("Xác nhận đăng nhập tại Diamond Time");
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
                    "        <div style=\"margin:50px auto;width:70%;padding:20px 0\">\n" +
                    "            <div\n" +
                    "                style=\"border-bottom:1px solid #eee; display: flex; justify-content: center; background: #e9c9a6; align-items: center\">\n" +
                    "                <a href=\"\" style=\"font-size:1.4em;color: #63101094;text-decoration:none;font-weight:600;justify-content: center;\n" +
                    "    align-items: center;\">DIAMOND TIME</a>\n" +
                    "            </div>\n" +
                    "\n" +
                    "            <p style=\"font-size:1.2em; color: black;\">Xin chào "+employee.getName()+"</p>\n" +
                    "            <p style=\"font-size:1.2em; color: black;\">Hãy nhập mã bên dưới để xác nhận đăng nhập hệ thống cho thiết bị mới</p>\n" +
                    "            <h2\n" +
                    "                style=\"background: #e4a25acf;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">\n" +
                    "                "+otp+"</h2>\n" +
                    "            <p style=\"font-size:1.1em; color: black;\">Vui lòng không chia sẻ mã này cho người bên ngoài,<br />Cảm ơn</p>\n" +
                    "            <hr style=\"border:none;border-top:1px solid #eee\" />\n" +
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

        iMailService.sendEmail(mail);

            AccountInfoDto accountInfoDto = new AccountInfoDto();
            accountInfoDto.setOtp(otp);
            accountInfoDto.setEmail(email);
            return new ResponseEntity<>(accountInfoDto, HttpStatus.OK);
        } else {
            return ResponseEntity.ok("Khong hop le");
        }

    }


    @PostMapping("/test")
    public ResponseEntity<Object> test(@RequestBody AccountDto accountDto) {
        Account accountDtoDB = iAccountService.findAccountByUsername(accountDto.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(accountDto.getPassword(), accountDtoDB.getPassword())) {
            return new ResponseEntity<>("true", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("false", HttpStatus.OK);
        }
    }

    @PostMapping("/confirm-otp")
    public ResponseEntity<Object> confirmOtp(@RequestBody Boolean isValidOtp) {
        if (isValidOtp) {
            return ResponseEntity.ok("Thanh cong");
        } else {
            return new ResponseEntity<>("that bai", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/getInfo")
    public ResponseEntity<Object> getInfo(@RequestHeader("Authorization") String token) {
        String newToken = token.substring(7);
        String userName = jwtService.getUsernameFromJwtToken(newToken);

        return ResponseEntity.ok(userName);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logoutSuccessful(@RequestHeader("Authorization") String token) {

//        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("logout-successfully");
    }


    @GetMapping("/k")
    public ResponseEntity<Object> k(@RequestBody Account account) {
        return ResponseEntity.ok("trang chu");

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/ad")
    public ResponseEntity<Object> kad() {
        return ResponseEntity.ok("trang ad");

    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/onlyUser")
    public ResponseEntity<Object> uu() {
        return ResponseEntity.ok("trang user");

    }

    public String generateFiveDigitInteger() {
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(randomNumber);
    }
}
