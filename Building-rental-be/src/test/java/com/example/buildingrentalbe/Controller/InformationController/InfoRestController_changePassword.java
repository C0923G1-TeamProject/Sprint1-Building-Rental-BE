package com.example.buildingrentalbe.Controller.InformationController;

import com.example.buildingrentalbe.dto.InformationDto;
import com.example.buildingrentalbe.dto.PasswordDto;
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
public class InfoRestController_changePassword {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword w passwordDto.setCurrentPassword is empty
     *
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void changePassword_1() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setCurrentPassword("");
        passwordDto.setNewPassword("123123");
        passwordDto.setConfirmNewPassword("123123");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/changed-password")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM4MTUzMiwiZXhwIjoxNzExNDY3OTMyfQ.iuBrYyc5bUu_Cw41MnPGWovuUznsW0UAKiUsx4uNlvs")
                                .content(this.objectMapper.writeValueAsString(passwordDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword with enter nothing
     *
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void changePassword_99() throws Exception {
        PasswordDto passwordDto = new PasswordDto();

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/changed-password")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM4MTUzMiwiZXhwIjoxNzExNDY3OTMyfQ.iuBrYyc5bUu_Cw41MnPGWovuUznsW0UAKiUsx4uNlvs")
                                .content(this.objectMapper.writeValueAsString(passwordDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword w passwordDto.setCurrentPassword is null
     *
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void changePassword_2() throws Exception{
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setCurrentPassword(null);
        passwordDto.setNewPassword("123");
        passwordDto.setConfirmNewPassword("123");

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/information/changed-password")
                        .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM4MTYyOSwiZXhwIjoxNzExNDY4MDI5fQ.lc-HwRiYPLcjVA53rE4RfZogpEiV89iM41-E7z5JxrQ")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword w passwordDto.setCurrentPassword equal passwordDto.setNewPassword
     *
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void changePassword_90() throws Exception{
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setCurrentPassword("123456");
        passwordDto.setNewPassword("123456");
        passwordDto.setConfirmNewPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/information/changed-password")
                        .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM4MTg2OCwiZXhwIjoxNzExNDY4MjY4fQ.Ib--xTs5uYrNmf9MCs1yct83CX7Ywt_3MbqvAKMiqIU")
                .content(this.objectMapper.writeValueAsString(passwordDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword w passwordDto.setConfirmNewPassword is not equal passwordDto.setNewPassword
     *
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void changePassword_91() throws Exception{
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setCurrentPassword("123456");
        passwordDto.setNewPassword("123123");
        passwordDto.setConfirmNewPassword("12");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/information/changed-password")
                        .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM4MTk4OSwiZXhwIjoxNzExNDY4Mzg5fQ.FImAfUehJ8zjVOXPad7BZAuALu90fNLvoAB2ffxJS3Y")
                .content(this.objectMapper.writeValueAsString(passwordDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword w passwordDto.setNewPassword is not has Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
     *
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void changePassword_92() throws Exception{
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setCurrentPassword("123");
        passwordDto.setNewPassword("123123");
        passwordDto.setConfirmNewPassword("123123");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/information/changed-password")
                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5Mjk1OSwiZXhwIjoxNzExNDc5MzU5fQ.xoy4PAwq64H8aoN60WyDeKiF0IvnNuV8tPjDpb81jmM")
                .content(this.objectMapper.writeValueAsString(passwordDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword w passwordDto.setNewPassword is not less than or equal to max length
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void changePassword_93() throws Exception{
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setCurrentPassword("123456");
        passwordDto.setNewPassword("1");
        passwordDto.setConfirmNewPassword("1");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/information/changed-password")
                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM4Mjg5NywiZXhwIjoxNzExNDY5Mjk3fQ.CDY5nmuWoc4UeWaubevNMaaxuLVJspOHHTAWLzlUJsA")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test changePassword successful
     * @throws Exception
     * return status 200 - successful
     */
    @Test
    public void changePassword_4() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setCurrentPassword("123456");
        passwordDto.setNewPassword("Passw0rd!123");
        passwordDto.setConfirmNewPassword("Passw0rd!123");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/changed-password")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM4MjE4OSwiZXhwIjoxNzExNDY4NTg5fQ.54YEE0y-OjE-IlsvUFyY5RVi7fJHgDyrmizb5_0JJa8")
                                .content(this.objectMapper.writeValueAsString(passwordDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
