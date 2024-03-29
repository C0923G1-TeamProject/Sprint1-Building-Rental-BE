package com.example.buildingrentalbe.controllers;

import com.example.buildingrentalbe.dto.AccountDto;
import com.example.buildingrentalbe.model.Account;
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
public class AuthController_login {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void login_13() throws Exception {
        AccountDto account = null;
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_14() throws Exception {
        AccountDto account = new AccountDto();
        account.setUsername("");
        account.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_18() throws Exception {
        AccountDto account = new AccountDto();
        account.setUsername("admin");
        account.setPassword("123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
