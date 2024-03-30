package com.example.buildingrentalbe.controller.ThamController;

import com.example.buildingrentalbe.dto.ContractDto;
import com.example.buildingrentalbe.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractController_createContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    /**
     * Created by: ThamTTH
     * Date created: 26/03/2024
     * Check case null code
     */
    @Test
    public void createContract_code_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode(null);
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");

        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
                this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: ThamTth
     * Date created: 26/03/2024
     * Check case null startDate
     */
    @Test
    public void createContract_startDate_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(null);
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");

        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTth
     * Date created: 25/03/2024
     * Check case null endDate
     */
    @Test
    public void createContract_endDate_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(null);
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");

        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTth
     * Date created: 25/03/2024
     * Check case null deposit
     */
    @Test
    public void createContract_deposit_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(null);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");

        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTth
     * Date created: 25/03/2024
     * Check case null content
     */
    @Test
    public void createContract_content_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent(null);
        contractDto.setPaymentTerm("10000000");

        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case null paymentTerm
     */
    @Test
    public void createContract_paymentTerm_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Test");
        contractDto.setPaymentTerm(null);

        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case null IdPremises
     */
    @Test
    public void createContract_idPremises_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Test");
        contractDto.setPaymentTerm("10000");

        contractDto.setIdPremises(null);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case null IdCustomer
     */
    @Test
    public void createContract_idCustomer_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Test");
        contractDto.setPaymentTerm("10000");

        contractDto.setIdPremises(1);
        contractDto.setIdCustomer(null);
        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case null IdAccount
     */
    @Test
    public void createContract_idAccount_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Test");
        contractDto.setPaymentTerm("10000");
        contractDto.setIdPremises(1);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(null);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case null IdContractStatus
     */
    @Test
    public void createContract_idContractStatus_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0010");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Test");
        contractDto.setPaymentTerm("10000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(1);

        contractDto.setIdContractStatus(null);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case all field is valid
     */
    @Test
    public void createContract_true_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0009");
        contractDto.setStartDate(LocalDate.parse("2024-03-28"));
        contractDto.setEndDate(LocalDate.parse("2025-03-28"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);


        contractDto.setIdAccount(2);

        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case validate code
     */
    @Test
    public void createContract_code_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-009");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case validate startDate, the start date cannot be less than the current date
     */
    @Test
    public void createContract_startDate_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0009");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2025-02-12"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case validate endDate, the end date should be greater than the current date
     */
    @Test
    public void createContract_endDate_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0009");
        contractDto.setStartDate(LocalDate.parse("2024-02-12"));
        contractDto.setEndDate(LocalDate.parse("2024-02-24"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case the end date should be greater than the start date
     */
    @Test
    public void createContract_startDate_endDate_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0009");
        contractDto.setStartDate(LocalDate.parse("2024-03-30"));
        contractDto.setEndDate(LocalDate.parse("2024-03-29"));
        contractDto.setDeposit(100000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case deposit < 0
     */
    @Test
    public void createContract_deposit_negative_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0009");
        contractDto.setStartDate(LocalDate.parse("2024-03-30"));
        contractDto.setEndDate(LocalDate.parse("2024-03-29"));
        contractDto.setDeposit(-100L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case deposit > 1000000000
     */
    @Test
    public void createContract_deposit_max_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HD-0009");
        contractDto.setStartDate(LocalDate.parse("2024-03-30"));
        contractDto.setEndDate(LocalDate.parse("2024-03-29"));
        contractDto.setDeposit(10000000000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case code is empty
     */
    @Test
    public void createContract_code_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("");
        contractDto.setStartDate(LocalDate.parse("2024-03-30"));
        contractDto.setEndDate(LocalDate.parse("2024-03-29"));
        contractDto.setDeposit(10000000L);
        contractDto.setContent("Bên A đồng ý các điều khoản bên B");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case content is empty
     */
    @Test
    public void createContract_content_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setCode("HĐ-0009");
        contractDto.setStartDate(LocalDate.parse("2024-03-30"));
        contractDto.setEndDate(LocalDate.parse("2024-03-29"));
        contractDto.setDeposit(1000000L);
        contractDto.setContent("");
        contractDto.setPaymentTerm("10000000");
        contractDto.setIdPremises(4);
        contractDto.setIdCustomer(1);
        contractDto.setIdAccount(2);
        contractDto.setIdContractStatus(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
