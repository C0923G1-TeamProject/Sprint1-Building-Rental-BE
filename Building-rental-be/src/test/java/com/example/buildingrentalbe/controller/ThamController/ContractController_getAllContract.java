package com.example.buildingrentalbe.controller.ThamController;

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
public class ContractController_getAllContract {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case empty all 2 input
     */
    @Test
    public void getAllContract_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/contract/search?page=0&nameCustomer=&statusContract= "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].code").value("HD-0001"))
                .andExpect(jsonPath("content[0].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[0].contractStatus").value("Còn hiệu lực"))
                .andExpect(jsonPath("content[0].startDate").value("2023-01-01"))
                .andExpect(jsonPath("content[0].paymentTerm").value("25000000"))
                .andExpect(jsonPath("content[0].endDate").value("2024-01-01"))
                .andExpect(jsonPath("content[0].deposit").value("25000000"))
                .andExpect(jsonPath("content[0].idContract").value("1"))
                .andExpect(jsonPath("content[0].nameAccount").value("vitkt"))
                .andExpect(jsonPath("content[0].codePremises").value("MB-001"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Đình Hòa"))
                .andExpect(jsonPath("content[1].code").value("HD-0002"))
                .andExpect(jsonPath("content[1].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[1].contractStatus").value("Còn hiệu lực"))
                .andExpect(jsonPath("content[1].startDate").value("2023-02-01"))
                .andExpect(jsonPath("content[1].paymentTerm").value("27000000"))
                .andExpect(jsonPath("content[1].endDate").value("2024-02-01"))
                .andExpect(jsonPath("content[1].deposit").value("227000000"))
                .andExpect(jsonPath("content[1].idContract").value("2"))
                .andExpect(jsonPath("content[1].nameAccount").value("thamtth"))
                .andExpect(jsonPath("content[1].codePremises").value("MB-002"))
                .andExpect(jsonPath("content[1].nameCustomer").value("Trần Văn Quang"));
    }

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case value nameCustomer is entered but not in the database, statusContract is empty
     */
    @Test
    public void getAllContract_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/contract/search?page=0&nameCustomer=Tui&statusContract= "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;}

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case value nameCustomer is empty, statusContract is entered but not in the database
     */
    @Test
    public void getAllContract_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/contract/search?page=0&nameCustomer=&statusContract=9 "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;}

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case value nameCustomer, statusContract is entered but nameCustomer isn't in the database
     */
    @Test
    public void getAllContract_96() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/contract/search?page=0&nameCustomer=Tui&statusContract=1 "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;}

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case nameCustomer doesn't exist in DB & statusContract is empty
     * Check case nameCustomer, statusContract is entered but doesn't exist in DB
     */
    @Test
    public void getAllContract_95() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/contract/search?page=0&nameCustomer=Tui&statusContract=9 "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;}

    /**
     * Created by: ThamTTH
     * Date created: 25/03/2024
     * Check case value nameCustomer, statusContract is entered and exist in the database
     */
    @Test
    public void getAllContract_94() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/contract/search?page=0&nameCustomer=Quang&statusContract=1 "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].code").value("HD-0002"))
                .andExpect(jsonPath("content[0].content").value("Bên A đồng ý các thỏa thuận"))
                .andExpect(jsonPath("content[0].contractStatus").value("Còn hiệu lực"))
                .andExpect(jsonPath("content[0].startDate").value("2023-02-01"))
                .andExpect(jsonPath("content[0].paymentTerm").value("27000000"))
                .andExpect(jsonPath("content[0].endDate").value("2024-02-01"))
                .andExpect(jsonPath("content[0].deposit").value("227000000"))
                .andExpect(jsonPath("content[0].idContract").value("2"))
                .andExpect(jsonPath("content[0].nameAccount").value("thamtth"))
                .andExpect(jsonPath("content[0].codePremises").value("MB-002"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Trần Văn Quang"))
        ;}
}
