package com.example.buildingrentalbe.controllers;

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
public class AuthController_confirmOtp {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void confirmOtp_13() throws Exception {
        Boolean isValidOtp = null;
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/confirm-otp"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void confirmOtp_18() throws Exception {
        Boolean isValidOtp = true;
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/confirm-otp"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
