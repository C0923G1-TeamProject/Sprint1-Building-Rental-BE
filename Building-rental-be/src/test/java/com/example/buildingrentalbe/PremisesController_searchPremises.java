package com.example.buildingrentalbe;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PremisesController_searchPremises {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: GiangTL
     * Date created: 25/03/2024
     * This method is used to test for function searchPremises with list size = 0
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void getPremises_98() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function searchPremises with list size = 0
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void getPremises_97() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is used to test for function searchPremises with list size > 0
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void getListPremises_96() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))  // số lượng phần tử có trong db


                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].area").value("100.0"))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[0].cost").value("1000"))
                .andExpect(jsonPath("content[0].description").value("1"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].price").value("12000000"))
                .andExpect(jsonPath("content[0].typePremises.name").value("mặt đứng"))
                .andExpect(jsonPath("content[0].premisesStatus.id").value("1"));

    }

    /**
     * This method is used to test for function searchPremises with list size > 0
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void getPremises_95() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))  // số lượng phần tử có trong db

                .andExpect(jsonPath("content[4].id").value("5"))
                .andExpect(jsonPath("content[4].area").value("564.0"))
                .andExpect(jsonPath("content[4].code").value("MB-0005"))
                .andExpect(jsonPath("content[4].cost").value("233"))
                .andExpect(jsonPath("content[4].floor").value("2"))
                .andExpect(jsonPath("content[4].price").value("1123412"))
                .andExpect(jsonPath("content[0].typePremises.name").value("mặt đứng"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("chưa bàn giao"));
    }

    /**
     * This method is used to test for function searchPremises with list size > 0
     * with description = " "
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void getListPremises_85() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))  // số lượng phần tử có trong db
                .andExpect(jsonPath("content[1].id").value("2"))
                .andExpect(jsonPath("content[1].area").value("200.0"))
                .andExpect(jsonPath("content[1].code").value("MB-0002"))
                .andExpect(jsonPath("content[1].cost").value("200"))
                .andExpect(jsonPath("content[1].description").value(""))
                .andExpect(jsonPath("content[1].floor").value("2"))
                .andExpect(jsonPath("content[1].price").value("300000"))
                .andExpect(jsonPath("content[1].typePremises.id").value("2"))
                .andExpect(jsonPath("content[1].premisesStatus.id").value("2"));
    }

    /**
     * This method is used to test the function searchPremises with display list
     * with parameter area is null, code = null, area= null, cost= null, description= "", floor=null, price= null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void getListStudent_94() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7)) // số lượng phần tử có trong db


                .andExpect(jsonPath("content[5].id").value("6"))
                .andExpect(jsonPath("content[5].area").value(Matchers.nullValue()))
                .andExpect(jsonPath("content[5].code").value(Matchers.nullValue()))
                .andExpect(jsonPath("content[5].cost").value(Matchers.nullValue()))
                .andExpect(jsonPath("content[5].description").value(""))
                .andExpect(jsonPath("content[5].floor").value(Matchers.nullValue()))
                .andExpect(jsonPath("content[5].price").value(Matchers.nullValue()));
    }

    /**
     * This method is used to test the function searchPremises with search by area and code
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllPremises_93() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search?&premisesStatus=&typePremises="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))

                .andExpect(jsonPath("content[0].area").value("100.0"))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[0].cost").value("1000"))
                .andExpect(jsonPath("content[0].description").value("1"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].price").value("12000000"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("chưa bàn giao"))
                .andExpect(jsonPath("content[0].typePremises.name").value("mặt đứng"));
    }

    /**
     * This method is used to test the function searchPremises with search by area="" or code= ""
     *
     * @return HTTPStatus.OK
     */

    @Test
    public void fillAllPremises_87() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search?&area="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))

                .andExpect(jsonPath("content[0].area").value("100.0"))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[1].area").value("200.0"))
                .andExpect(jsonPath("content[1].code").value("MB-0002"))
                .andExpect(jsonPath("content[2].code").value("MB-0003"))
                .andExpect(jsonPath("content[2].area").value("300.0"));
    }


    /**
     * This method is used to test the function searchPremises with paging
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllPremises_90() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                /** Test số trang số trang */
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7));
    }

    /**
     * check for empty value description = " "
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllPremises_88() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())

                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))
                /** Nhập sai giá trị description */
                .andExpect(jsonPath("content[2].id").value("3"))
                .andExpect(jsonPath("content[2].area").value("300.0"))
                .andExpect(jsonPath("content[2].code").value("MB-0003"))
                .andExpect(jsonPath("content[2].description").value("9"))
                .andExpect(jsonPath("content[2].floor").value("3"))
                .andExpect(jsonPath("content[2].price").value("675272"));
    }

    /**
     * check for data that is not in the database
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllPremises_86() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))
                .andExpect(jsonPath("content[9]").doesNotExist()); // Kiểm tra xem phần tử thứ 10 có tồn tại không
    }


    /**
     * Check if the data is wrong area= ?
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllPremises_85() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search")
                                .param("area", "invalid_value")) // Giá trị không hợp lệ cho tham số area
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    

}

