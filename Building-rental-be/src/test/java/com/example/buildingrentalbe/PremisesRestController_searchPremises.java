package com.example.buildingrentalbe;

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
public class PremisesRestController_searchPremises {
    @Autowired
    private MockMvc mockMvc;

    /*Creator: Hoàng Trần Văn Hiếu
    * Date created: 26/03/2024
    * Check empty all inputs
    * */
    @Test
    public void searchPremises_99() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("MB-001"))
                .andExpect(jsonPath("content[0].price").value(12000000))
                .andExpect(jsonPath("content[0].floor").value(1))
                .andExpect(jsonPath("content[0].cost").value(500000))
                .andExpect(jsonPath("content[0].area").value(100.0))
                .andExpect(jsonPath("content[0].description").value(""))
                .andExpect(jsonPath("content[0].typePremises.id").value(1))
                .andExpect(jsonPath("content[0].typePremises.name").value("Mặt tiền"))
                .andExpect(jsonPath("content[0].premisesStatus.id").value("1"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("Chưa bàn giao"))
                .andExpect(jsonPath("content[3].id").value(4))
                .andExpect(jsonPath("content[3].code").value("MB-5678"))
                .andExpect(jsonPath("content[3].price").value(120000000))
                .andExpect(jsonPath("content[3].floor").value(2))
                .andExpect(jsonPath("content[3].cost").value(100000))
                .andExpect(jsonPath("content[3].area").value(150.5))
                .andExpect(jsonPath("content[3].description").value("abc"))
                .andExpect(jsonPath("content[3].typePremises.id").value(1))
                .andExpect(jsonPath("content[3].typePremises.name").value("Mặt tiền"))
                .andExpect(jsonPath("content[3].premisesStatus.id").value("1"))
                .andExpect(jsonPath("content[3].premisesStatus.name").value("Chưa bàn giao"));
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'floor' is null
     * */
    @Test
    public void searchPremises_floor_1() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?floor=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'floor' empty
     * */
    @Test
    public void searchPremises_floor_2() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?floor="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("MB-001"))
                .andExpect(jsonPath("content[0].price").value(12000000))
                .andExpect(jsonPath("content[0].floor").value(1))
                .andExpect(jsonPath("content[0].cost").value(500000))
                .andExpect(jsonPath("content[0].area").value(100.0))
                .andExpect(jsonPath("content[0].description").value(""))
                .andExpect(jsonPath("content[0].typePremises.id").value(1))
                .andExpect(jsonPath("content[0].typePremises.name").value("Mặt tiền"))
                .andExpect(jsonPath("content[0].premisesStatus.id").value("1"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("Chưa bàn giao"))
                .andExpect(jsonPath("content[3].id").value(4))
                .andExpect(jsonPath("content[3].code").value("MB-5678"))
                .andExpect(jsonPath("content[3].price").value(120000000))
                .andExpect(jsonPath("content[3].floor").value(2))
                .andExpect(jsonPath("content[3].cost").value(100000))
                .andExpect(jsonPath("content[3].area").value(150.5))
                .andExpect(jsonPath("content[3].description").value("abc"))
                .andExpect(jsonPath("content[3].typePremises.id").value(1))
                .andExpect(jsonPath("content[3].typePremises.name").value("Mặt tiền"))
                .andExpect(jsonPath("content[3].premisesStatus.id").value("1"))
                .andExpect(jsonPath("content[3].premisesStatus.name").value("Chưa bàn giao"));
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'floor' has in database
     * */
    @Test
    public void searchPremises_floor_4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?floor=3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].id").value(3))
                .andExpect(jsonPath("content[0].code").value("MB-003"))
                .andExpect(jsonPath("content[0].price").value(130000000))
                .andExpect(jsonPath("content[0].floor").value(3))
                .andExpect(jsonPath("content[0].cost").value(500000))
                .andExpect(jsonPath("content[0].area").value(1220.0))
                .andExpect(jsonPath("content[0].description").value(""))
                .andExpect(jsonPath("content[0].typePremises.id").value(3))
                .andExpect(jsonPath("content[0].typePremises.name").value("Mặt hậu"))
                .andExpect(jsonPath("content[0].premisesStatus.id").value("2"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("Đã bàn giao"));
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search empty 'code'
     * */
    @Test
    public void searchPremises_code_1() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?code="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("MB-001"))
                .andExpect(jsonPath("content[0].price").value(12000000))
                .andExpect(jsonPath("content[0].floor").value(1))
                .andExpect(jsonPath("content[0].cost").value(500000))
                .andExpect(jsonPath("content[0].area").value(100.0))
                .andExpect(jsonPath("content[0].description").value(""))
                .andExpect(jsonPath("content[0].typePremises.id").value(1))
                .andExpect(jsonPath("content[0].typePremises.name").value("Mặt tiền"))
                .andExpect(jsonPath("content[0].premisesStatus.id").value("1"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("Chưa bàn giao"))
                .andExpect(jsonPath("content[3].id").value(4))
                .andExpect(jsonPath("content[3].code").value("MB-5678"))
                .andExpect(jsonPath("content[3].price").value(120000000))
                .andExpect(jsonPath("content[3].floor").value(2))
                .andExpect(jsonPath("content[3].cost").value(100000))
                .andExpect(jsonPath("content[3].area").value(150.5))
                .andExpect(jsonPath("content[3].description").value("abc"))
                .andExpect(jsonPath("content[3].typePremises.id").value(1))
                .andExpect(jsonPath("content[3].typePremises.name").value("Mặt tiền"))
                .andExpect(jsonPath("content[3].premisesStatus.id").value("1"))
                .andExpect(jsonPath("content[3].premisesStatus.name").value("Chưa bàn giao"));
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'code' has in database
     * */
    @Test
    public void searchPremises_code_4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?code=MB-003"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].id").value(3))
                .andExpect(jsonPath("content[0].code").value("MB-003"))
                .andExpect(jsonPath("content[0].price").value(130000000))
                .andExpect(jsonPath("content[0].floor").value(3))
                .andExpect(jsonPath("content[0].cost").value(500000))
                .andExpect(jsonPath("content[0].area").value(1220.0))
                .andExpect(jsonPath("content[0].description").value(""))
                .andExpect(jsonPath("content[0].typePremises.id").value(3))
                .andExpect(jsonPath("content[0].typePremises.name").value("Mặt hậu"))
                .andExpect(jsonPath("content[0].premisesStatus.id").value("2"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("Đã bàn giao"));
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'code' not exist in database
     * */
    @Test
    public void searchPremises_code_5() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?code=ABC-1212"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'area' null
     * */
    @Test
    public void searchPremises_area_1() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?area=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'area' empty
     * */
    @Test
    public void searchPremises_area_2() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?area="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'area' invalid in database
     * */
    @Test
    public void searchPremises_area_3() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?area=10"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check search 'area' valid in database
     * */
    @Test
    public void searchPremises_area_4() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/premises/search?area=100"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("MB-001"))
                .andExpect(jsonPath("content[0].price").value(12000000))
                .andExpect(jsonPath("content[0].floor").value(1))
                .andExpect(jsonPath("content[0].cost").value(500000))
                .andExpect(jsonPath("content[0].area").value(100.0))
                .andExpect(jsonPath("content[0].description").value(""))
                .andExpect(jsonPath("content[0].typePremises.id").value(1))
                .andExpect(jsonPath("content[0].typePremises.name").value("Mặt tiền"))
                .andExpect(jsonPath("content[0].premisesStatus.id").value("1"))
                .andExpect(jsonPath("content[0].premisesStatus.name").value("Chưa bàn giao"));
    }


}
