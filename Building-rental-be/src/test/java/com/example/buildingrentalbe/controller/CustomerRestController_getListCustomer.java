package com.example.buildingrentalbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_getListCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetListCustomer_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/show")
                                .param("name", "")
                                .param("card", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetListCustomer_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/show")
                                .param("name",  null)
                                .param("card",  null))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetListCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/show/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetListCustomer_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/show?page=0")
                                .param("name", "Nguyễn")
                                .param("card",  null))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("Nguyễn Văn Cường"))
                .andExpect(jsonPath("content[0].card").value("123456789101"))
                .andExpect(jsonPath("content[0].email").value("cuongnv@gmail.com"))
                .andExpect(jsonPath("content[0].date").value("2021-03-22"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0988575981"))
                .andExpect(jsonPath("content[0].address").value("Cầu Giấy,Hà Nội"))
                .andExpect(jsonPath("content[0].url").value("hoahuongduong.com"))
                .andExpect(jsonPath("content[0].company").value("Hoa Hướng Dương"))
                .andExpect(jsonPath("content[0].img").value("https://studiochupanhdep.com/Upload/Images/Album/anh-the-2024.jpg"))
                .andExpect(jsonPath("content[2].name").value("Nguyễn Đình Long"))
                .andExpect(jsonPath("content[2].card").value("343432432"))
                .andExpect(jsonPath("content[2].email").value("dongnguyen@gmail.com"))
                .andExpect(jsonPath("content[2].date").value("1992-09-03"))
                .andExpect(jsonPath("content[2].phoneNumber").value("9542131232"))
                .andExpect(jsonPath("content[2].address").value("Thành phố Hà Nội"))
                .andExpect(jsonPath("content[2].url").value("hoacuc.com"))
                .andExpect(jsonPath("content[2].company").value("Nguyễn Ngọc Đông"))
                .andExpect(jsonPath("content[2].img").value("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg"));
    }

    @Test
    public void testGetListCustomer_9_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/show?page=0")
                                .param("name", "Nguyễn")
                                .param("card", "34343"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetListCustomer_9_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/show?page=0")
                                .param("name", (String) null)
                                .param("card", "34343"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
