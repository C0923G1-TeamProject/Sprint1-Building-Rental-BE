package com.example.buildingrentalbe.controller.contractController;

import com.example.buildingrentalbe.dto.ContractDto;
import com.example.buildingrentalbe.dto.RequestContractDto;
import com.example.buildingrentalbe.dto.RequestContractEmployeeDto;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractController_getAllContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Date fixed: 03/04/2024
     * Check case empty all 3 input search by customer, search by employee and search by status
     */
    @Test
    public void getAllContract_99() throws Exception {
        RequestContractDto requestContractDto = new RequestContractDto();
        requestContractDto.setPage(0);
        requestContractDto.setSize(2);
        requestContractDto.setIdContractStatus(-1);
        requestContractDto.setNameCustomer("");
        requestContractDto.setNameEmployee("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract")
                        .content(this.objectMapper.writeValueAsString(requestContractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(10))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[0].code").value("HD-0001"))
                .andExpect(jsonPath("content[0].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[0].contractStatus.name").value("Hết hiệu lực"))
                .andExpect(jsonPath("content[0].startDate").value("2023-01-01"))
                .andExpect(jsonPath("content[0].paymentTerm").value("25000000"))
                .andExpect(jsonPath("content[0].endDate").value("2024-01-01"))
                .andExpect(jsonPath("content[0].deposit").value("25000000"))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("Trần Thị Hồng Thắm"))
                .andExpect(jsonPath("content[0].premises.code").value("MB-001"))
                .andExpect(jsonPath("content[0].customer.name").value("Nguyễn Đình Hòa"))
                .andExpect(jsonPath("content[1].code").value("HD-0002"))
                .andExpect(jsonPath("content[1].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[1].contractStatus.name").value("Hết hiệu lực"))
                .andExpect(jsonPath("content[1].startDate").value("2023-02-01"))
                .andExpect(jsonPath("content[1].paymentTerm").value("27000000"))
                .andExpect(jsonPath("content[1].endDate").value("2024-02-01"))
                .andExpect(jsonPath("content[1].deposit").value("227000000"))
                .andExpect(jsonPath("content[1].id").value("2"))
                .andExpect(jsonPath("content[1].nameEmployee").value("Trần Thị Hồng Thắm"))
                .andExpect(jsonPath("content[1].premises.code").value("MB-002"))
                .andExpect(jsonPath("content[1].customer.name").value("Trần Văn Quang"));
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Date fixed: 03/04/2024
     * Check case enter input search by customer has in DB, no enter search by employee and search by status
     */
    @Test
    public void getAllContract_98() throws Exception {
            RequestContractDto requestContractDto = new RequestContractDto();
            requestContractDto.setPage(0);
            requestContractDto.setSize(2);
            requestContractDto.setIdContractStatus(-1);
            requestContractDto.setNameCustomer("Hòa");
            requestContractDto.setNameEmployee("");
            this.mockMvc.perform(MockMvcRequestBuilders
                            .post("/contract")
                            .content(this.objectMapper.writeValueAsString(requestContractDto))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(jsonPath("totalPages").value(1))
                    .andExpect(jsonPath("totalElements").value(1))
                    .andExpect(jsonPath("content[0].code").value("HD-0001"))
                    .andExpect(jsonPath("content[0].content").value("Bên A đồng ý các thỏa thuận"))
                    .andExpect(jsonPath("content[0].contractStatus.name").value("Hết hiệu lực"))
                    .andExpect(jsonPath("content[0].startDate").value("2023-01-01"))
                    .andExpect(jsonPath("content[0].paymentTerm").value("25000000"))
                    .andExpect(jsonPath("content[0].endDate").value("2024-01-01"))
                    .andExpect(jsonPath("content[0].deposit").value("25000000"))
                    .andExpect(jsonPath("content[0].id").value("1"))
                    .andExpect(jsonPath("content[0].nameEmployee").value("Trần Thị Hồng Thắm"))
                    .andExpect(jsonPath("content[0].premises.code").value("MB-001"))
                    .andExpect(jsonPath("content[0].customer.name").value("Nguyễn Đình Hòa"));
        }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Date fixed: 03/04/2024
     * Check case enter input search by customer, search by employee has in DB, no enter search by status
     */
    @Test
    public void getAllContract_97() throws Exception {
        RequestContractDto requestContractDto = new RequestContractDto();
        requestContractDto.setPage(0);
        requestContractDto.setSize(2);
        requestContractDto.setIdContractStatus(-1);
        requestContractDto.setNameCustomer("Hòa");
        requestContractDto.setNameEmployee("Thắm");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract")
                        .content(this.objectMapper.writeValueAsString(requestContractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].code").value("HD-0001"))
                .andExpect(jsonPath("content[0].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[0].contractStatus.name").value("Hết hiệu lực"))
                .andExpect(jsonPath("content[0].startDate").value("2023-01-01"))
                .andExpect(jsonPath("content[0].paymentTerm").value("25000000"))
                .andExpect(jsonPath("content[0].endDate").value("2024-01-01"))
                .andExpect(jsonPath("content[0].deposit").value("25000000"))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("Trần Thị Hồng Thắm"))
                .andExpect(jsonPath("content[0].premises.code").value("MB-001"))
                .andExpect(jsonPath("content[0].customer.name").value("Nguyễn Đình Hòa"));
    }



    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Date fixed: 03/04/2024
     * Check case enter input search by customer, search by employee, search by status has in DB
     */
    @Test
    public void getAllContract_96() throws Exception {
        RequestContractDto requestContractDto = new RequestContractDto();
        requestContractDto.setPage(0);
        requestContractDto.setSize(2);
        requestContractDto.setIdContractStatus(2);
        requestContractDto.setNameCustomer("Hòa");
        requestContractDto.setNameEmployee("Thắm");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract")
                        .content(this.objectMapper.writeValueAsString(requestContractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].code").value("HD-0001"))
                .andExpect(jsonPath("content[0].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[0].contractStatus.name").value("Hết hiệu lực"))
                .andExpect(jsonPath("content[0].startDate").value("2023-01-01"))
                .andExpect(jsonPath("content[0].paymentTerm").value("25000000"))
                .andExpect(jsonPath("content[0].endDate").value("2024-01-01"))
                .andExpect(jsonPath("content[0].deposit").value("25000000"))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("Trần Thị Hồng Thắm"))
                .andExpect(jsonPath("content[0].premises.code").value("MB-001"))
                .andExpect(jsonPath("content[0].customer.name").value("Nguyễn Đình Hòa"));
    }


    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Date fixed: 03/04/2024
     * Check case enter input search by customer, search by employee, search by status has in DB
     */
    @Test
    public void getAllContract_95() throws Exception {
        RequestContractDto requestContractDto = new RequestContractDto();
        requestContractDto.setPage(0);
        requestContractDto.setSize(2);
        requestContractDto.setIdContractStatus(2);
        requestContractDto.setNameCustomer("Hòa");
        requestContractDto.setNameEmployee("Thắm");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/contract")
                        .content(this.objectMapper.writeValueAsString(requestContractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].code").value("HD-0001"))
                .andExpect(jsonPath("content[0].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[0].contractStatus.name").value("Hết hiệu lực"))
                .andExpect(jsonPath("content[0].startDate").value("2023-01-01"))
                .andExpect(jsonPath("content[0].paymentTerm").value("25000000"))
                .andExpect(jsonPath("content[0].endDate").value("2024-01-01"))
                .andExpect(jsonPath("content[0].deposit").value("25000000"))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("Trần Thị Hồng Thắm"))
                .andExpect(jsonPath("content[0].premises.code").value("MB-001"))
                .andExpect(jsonPath("content[0].customer.name").value("Nguyễn Đình Hòa"));
    }


}
