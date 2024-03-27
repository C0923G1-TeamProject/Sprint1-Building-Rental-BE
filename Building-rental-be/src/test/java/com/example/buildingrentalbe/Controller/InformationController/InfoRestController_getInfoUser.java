package com.example.buildingrentalbe.Controller.InformationController;

import com.example.buildingrentalbe.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.security.Principal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InfoRestController_getInfoUser {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test getInfoUser with wrong token
     *
     * @throws Exception return status 400 - client error
     */
    @Test
    public void getInfoUser_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/information/getInformationUser/")
                        .header("authorization", "Bearer anbnabdnmada"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test getInfoUser with principal empty
     *
     * @throws Exception return status 400 - client error
     */
    @Test
    public void getInfoUser_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/information/getInformationUser/", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test getInfoUser with principal is not exists
     *
     * @throws Exception return status 400 - client error
     */
    @Test
    public void getInfoUser_3() throws Exception {
        String username = "abc";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/information/getInformationUser/", username))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test getInfoUser with token
     *
     * @throws Exception
     * return status 200 - successful
     */
    @Test
    public void getInfoUser_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/information/getInformationUser", "")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTQzNTM2NCwiZXhwIjoxNzExNTIxNzY0fQ.ePXQAcG3e-8qsENULx-lanQZYCotsd3_9HMmISu86j0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
