package com.example.buildingrentalbe.Controller.InformationController;

import com.example.buildingrentalbe.dto.InformationDto;
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
public class InfoRestController_updateInfoUser {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

// informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with all properties enter nothing
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_90() throws Exception{
        InformationDto informationDto = new InformationDto();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/information/updateInformation")
                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTQyMiwiZXhwIjoxNzExNDc3ODIyfQ.xrOPCPlmuwMFJOEoOk9xq0SRQWYdXXklIyMfg7aJ8K4")
                .content(this.objectMapper.writeValueAsString(informationDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with name is empty
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_89() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setName("");

        informationDto.setId(1);
        informationDto.setDate("2024-03-10");
        informationDto.setGender(false);
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh Khê, Thành phố Đà Nẵng");
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/information/updateInformation")
                        .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                        .content(this.objectMapper.writeValueAsString(informationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with address is empty
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_88() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setAddress("");

        informationDto.setId(1);
        informationDto.setName("tktvi");
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setDate("2024-03-10");
        informationDto.setGender(false);
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with email is empty
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_87() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setEmail("");

        informationDto.setId(1);
        informationDto.setName("tktvi");
        informationDto.setDate("2024-03-10");
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh Khê,Thành phố Đà Nẵng");
        informationDto.setGender(false);
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with name is null
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_86() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setName(null);

        informationDto.setId(1);
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setDate("2024-03-10");
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh Khê,Thành phố Đà Nẵng");
        informationDto.setGender(false);
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with address is null
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_85() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setAddress(null);

        informationDto.setId(1);
        informationDto.setName("Trần Kim Tiểu Vi");
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setGender(false);
        informationDto.setDate("2009-09-09");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with email is null
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_84() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setEmail(null);

        informationDto.setId(1);
        informationDto.setName("Trần Kim Tiểu Vi");
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh Khê, Thành phố Đà Nẵng");
        informationDto.setGender(false);
        informationDto.setDate("2009-09-09");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with address not less than or equal to max length
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_83() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setAddress("12");

        informationDto.setId(1);
        informationDto.setName("Trần Kim Tiểu Vi");
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setGender(false);
        informationDto.setDate("2009-09-09");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with name incorrect format
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_82() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setName("12");

        informationDto.setId(1);
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh khê, Thành phố Đà Nẵng");
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setGender(false);
        informationDto.setDate("2009-09-09");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with name not less than or equal to max length
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_81() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setName("1");

        informationDto.setId(1);
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh khê, Thành phố Đà Nẵng");
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setGender(false);
        informationDto.setDate("2009-09-09");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with email incorrect format
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_80() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setEmail("john doe@example.com");

        informationDto.setId(1);
        informationDto.setName("Trần Kim Tiểu Vi");
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh Khê, Thành phố Đà Nẵng");
        informationDto.setGender(false);
        informationDto.setDate("2009-09-09");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser with birthday is empty
     * @throws Exception
     * return status 400 - client error
     */
    @Test
    public void updateInfoUser_79() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setDate("");

        informationDto.setEmail("abc12@gmail.com");
        informationDto.setId(1);
        informationDto.setName("Trần Kim Tiểu Vi");
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh Khê, Thành phố Đà Nẵng");
        informationDto.setGender(false);
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/information/updateInformation")
                                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTM5MTAyNiwiZXhwIjoxNzExNDc3NDI2fQ.mwBFXcmCQzIScdhKmW5iih0y8Fcf9s3_vaMtvzOIRYY")
                                .content(this.objectMapper.writeValueAsString(informationDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: ViTKT
     * Since: 25/03/2024
     * JUnit test updateInfoUser successful
     * @throws Exception
     * return status 200 - successful
     */
    @Test
    public void updateInfoUser_4() throws Exception{
        InformationDto informationDto = new InformationDto();
        informationDto.setId(1);
        informationDto.setName("Trần Kim Tiểu Vi");
        informationDto.setAddress("295 Nguyễn Tất Thành,Quận Thanh Khê, Thành phố Đà Nẵng");
        informationDto.setEmail("hinhhockhonggian3@gmail.com");
        informationDto.setGender(false);
        informationDto.setDate("2009-09-09");
        informationDto.setProfilePicture("https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/information/updateInformation")
                .header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXRrdCIsImlhdCI6MTcxMTQyMTkxMSwiZXhwIjoxNzExNTA4MzExfQ.eNKZdO-EEA8sh_s1SUXMqMCP77XVx1OvkcKv4skg8eY")
                .content(this.objectMapper.writeValueAsString(informationDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
