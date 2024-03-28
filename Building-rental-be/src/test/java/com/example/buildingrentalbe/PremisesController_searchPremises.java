package com.example.buildingrentalbe;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PremisesController_searchPremises {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * This method test for function searchPremises (return list premises)
     */
    @Test
    public void getPremises_98() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * check input area="", code="", cost="", description="", floor="", price="", premisesStatus="", TypePremises=""
     */
    @Test
    public void getPremises_97() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search")
                                .param("area", "")
                                .param("code", "")
                                .param("cost", "")
                                .param("description", "")
                                .param("floor", "")
                                .param("price", "")
                                .param("premisesStatus", "")
                                .param("TypePremises", "")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * check empty all input DB
     */
    @Test
    public void getPremises_96() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].area").value(100))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[0].cost").value(10000))
                .andExpect(jsonPath("content[0].description").value("đẹp"))
                .andExpect(jsonPath("content[0].floor").value(2))
                .andExpect(jsonPath("content[0].price").value(20000))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("mặt đứng"))
                .andExpect(jsonPath("content[0].typePremises.name").value("chưa bàn giao"));
    }


    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * Check search 'code' is null
     */
    @Test
    public void getPremises_95() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/premises/search?code=null")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * check search floor empty
     */
    @Test
    public void getPremises_94() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search?floor="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].area").value(100))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[0].cost").value(10000))
                .andExpect(jsonPath("content[0].description").value("đẹp"))
                .andExpect(jsonPath("content[0].floor").value(2))
                .andExpect(jsonPath("content[0].price").value(20000))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("mặt đứng"))
                .andExpect(jsonPath("content[0].typePremises.name").value("chưa bàn giao"))
                .andExpect(jsonPath("content[1].id").value(2))
                .andExpect(jsonPath("content[1].area").value(200))
                .andExpect(jsonPath("content[1].code").value("MB-0002"))
                .andExpect(jsonPath("content[1].cost").value(20000))
                .andExpect(jsonPath("content[1].description").value("xấu"))
                .andExpect(jsonPath("content[1].floor").value(1))
                .andExpect(jsonPath("content[1].price").value(30000))
                .andExpect(jsonPath("content[1].premisesStatus.name").value("mặt đứng"))
                .andExpect(jsonPath("content[1].typePremises.name").value("đã bàn giao"));
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * check search code in DB
     */
    @Test
    public void getPremises_93() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search?code=MB-0001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].area").value(100))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[0].cost").value(10000))
                .andExpect(jsonPath("content[0].description").value("đẹp"))
                .andExpect(jsonPath("content[0].floor").value(2))
                .andExpect(jsonPath("content[0].price").value(20000))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("mặt đứng"))
                .andExpect(jsonPath("content[0].typePremises.name").value("chưa bàn giao"));
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * Check search 'floor' has in DB
     */
    @Test
    public void getPremises_92() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search?floor=2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].area").value(100))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[0].cost").value(10000))
                .andExpect(jsonPath("content[0].description").value("đẹp"))
                .andExpect(jsonPath("content[0].floor").value(2))
                .andExpect(jsonPath("content[0].price").value(20000))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("mặt đứng"))
                .andExpect(jsonPath("content[0].typePremises.name").value("chưa bàn giao"));
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * Check search 'code' has in DB
     */
    @Test
    public void getPremises_91() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search?floor="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].area").value(100))
                .andExpect(jsonPath("content[0].code").value("MB-0001"))
                .andExpect(jsonPath("content[0].cost").value(10000))
                .andExpect(jsonPath("content[0].description").value("đẹp"))
                .andExpect(jsonPath("content[0].floor").value(2))
                .andExpect(jsonPath("content[0].price").value(20000))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("mặt đứng"))
                .andExpect(jsonPath("content[0].typePremises.name").value("chưa bàn giao"))
                .andExpect(jsonPath("content[1].id").value(2))
                .andExpect(jsonPath("content[1].area").value(200))
                .andExpect(jsonPath("content[1].code").value("MB-0002"))
                .andExpect(jsonPath("content[1].cost").value(20000))
                .andExpect(jsonPath("content[1].description").value("xấu"))
                .andExpect(jsonPath("content[1].floor").value(1))
                .andExpect(jsonPath("content[1].price").value(30000))
                .andExpect(jsonPath("content[1].premisesStatus.name").value("mặt đứng"))
                .andExpect(jsonPath("content[1].typePremises.name").value("đã bàn giao"));
    }


    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * Check search 'code' not exist in DB
     */
    @Test
    public void getPremises_90() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?code=BHGFGF-523845623874"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * Check 'cost' null
     */
    @Test
    public void getPremises_89() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?cost=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * Check 'floor' null
     */
    @Test
    public void getPremises_88() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?floor=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: Trần Linh Giang
     * Date created: 26/03/2024
     * Check paging
     */
    @Test
    public void getPremises_94_paging() throws Exception {
        int pageSize = 1; // Số lượng phần tử trên mỗi trang
        int pageNumber = 0; // Số trang bắt đầu từ 0

        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/premises/search")
                                .param("floor", "")
                                .param("page", String.valueOf(pageNumber))
                                .param("size", String.valueOf(pageSize))
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content").isArray())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(result.getResponse().getContentAsString());

        /* Kiểm tra số lượng trang */
        int totalPages = responseJson.get("totalPages").asInt();
        assertEquals(3, totalPages); // Đổi thành số trang thực tế trong DB

        /* Kiểm tra số lượng phần tử trên trang hiện tại*/
        int actualPageSize = responseJson.get("numberOfElements").asInt();
        assertEquals(pageSize, actualPageSize);

        /* Kiểm tra nội dung của trang hiện tại */
        JsonNode contentArray = responseJson.get("content");
        assertEquals(pageSize, contentArray.size());

    }


}

