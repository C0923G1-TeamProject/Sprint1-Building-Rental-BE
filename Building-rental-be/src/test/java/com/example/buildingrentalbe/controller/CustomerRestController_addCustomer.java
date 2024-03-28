package com.example.buildingrentalbe.controller;

import com.example.buildingrentalbe.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_addCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddCustomer_name_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(null);
        customerDto.setCard("123456789121");
        customerDto.setEmail("abc@gmail.com");
        customerDto.setDate("1992-09-03");
        customerDto.setPhoneNumber("0988575981");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setUrl("hoamai.com");
        customerDto.setCompany("Hoa Mai");
        customerDto.setImg("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/customer/add")
                                .content(this.objectMapper.writeValueAsBytes(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testAddCustomer_email_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Nguyễn Văn Giàu");
        customerDto.setCard("123456789123");
        customerDto.setEmail("");
        customerDto.setDate("1992-09-03");
        customerDto.setPhoneNumber("0988575981");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setUrl("hoamai.com");
        customerDto.setCompany("Hoa Mai");
        customerDto.setImg("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/customer/add")
                                .content(this.objectMapper.writeValueAsBytes(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testAddCustomer_card_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Nguyễn Văn Giàu");
        customerDto.setCard("123");
        customerDto.setEmail("abc@gmail.com");
        customerDto.setDate("1992-09-03");
        customerDto.setPhoneNumber("0988575981");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setUrl("hoamai.com");
        customerDto.setCompany("Hoa Mai");
        customerDto.setImg("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/customer/add")
                                .content(this.objectMapper.writeValueAsBytes(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testAddCustomer_18() throws Exception{
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Trần Giàu");
        customerDto.setCard("123456789123");
        customerDto.setEmail("abc@gmail.com");
        customerDto.setDate("1992-09-03");
        customerDto.setPhoneNumber("0988575981");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setUrl("hoamai.com");
        customerDto.setCompany("Hoa Mai");
        customerDto.setImg("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/customer/add")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
