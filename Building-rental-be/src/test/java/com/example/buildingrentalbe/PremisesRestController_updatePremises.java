package com.example.buildingrentalbe;

import com.example.buildingrentalbe.dto.PremisesDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.support.NullValue;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PremisesRestController_updatePremises {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'code' doesn't match regexp
     * */
    @Test
    public void updatePremises_code_19() throws Exception{
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'code' null
     * */
    @Test
    public void testCodeNotNullValidation() throws Exception {
        String testData = "{\n" +
                "    \"code\": null,\n" +       //trường 'code' là null
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }


    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'floor' null
     * */
    @Test
    public void testFloorNotNullValidation() throws Exception {

        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": null,\n" + // Trường 'floor' là null
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'typePremisesId' null
     * */
    @Test
    public void testTypePremisesIdNotNullValidation() throws Exception {
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": null,\n" + // Trường 'typePremises' là null
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }


    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'premisesStatus id' null
     * */
    @Test
    public void testPremisesStatusNotNullValidation() throws Exception {
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": null\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'area' not a number
     * */
    @Test
    public void testAreaInvalidCharacterValidation() throws Exception {

        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": \"invalid\" \n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'area' empty
     * */
    @Test
    public void testEmptyAreaValidation() throws Exception {
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": \"\",\n" + // Trường 'area' rỗng
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'area' < 10
     * */
    @Test
    public void testAreaMinValueValidation() throws Exception {
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 5.0,\n" + // Trường 'area' nhỏ hơn 10.0
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'area' > 999999
     * */
    @Test
    public void testAreaMaxValueValidation() throws Exception {

        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 1000000.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'area' null
     * */
    @Test
    public void testAreaNullValidation() throws Exception {
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": null,\n" + // Trường 'area' là null
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'description' > 255 characters
     * */
    @Test
    public void testDescriptionLengthValidation() throws Exception {

        StringBuilder longDescription = new StringBuilder();
        for (int i = 0; i < 260; i++) {
            longDescription.append("a");
        }

        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 12000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"" + "Bộ Công an chưa công bố hành vi cụ thể của ông Thủy. Còn trước đó, Công an TP HCM nhận được hàng trăm đơn tố cáo của phụ huynh tại TP HCM, cho rằng bị Công ty CP Anh ngữ Apax Leaders \"chiếm đoạt tiền học phí\" khoảng 6 tỷ đồng. Trong đơn, họ cho biết đã phải chi hàng trăm triệu đồng mua khóa học tiếng Anh tại Apax Leaders cho con nhưng các cháu không được học vì trung tâm đã đóng cửa, đòi lại tiền thì không được.\n" +
                "\n" +
                "Hôm 9/1, Chủ tịch Egroup thông báo gặp \"khó khăn đặc biệt\" khi một số trung tâm tại TP HCM phải tạm dừng do một nhóm phụ huynh đến bao vây, đòi lại học phí. Điều này được cho là gây ảnh hưởng đến hoạt động kinh doanh và nguồn thu của công ty. Nhân sự lo sợ nghỉ việc, tăng số lượng rút phí do các trung tâm đang hoạt động không thể giảng dạy trực tiếp cho học sinh...\n" +
                "\n" +
                "Trong thông báo, ông Thủy cũng cho rằng, việc này \"khiến Apax Leaders mất khả năng hoàn phí các đợt tiếp theo cho phụ huynh\". Hiện công ty Shark Thủy đã dừng giảng dạy trực tiếp tại các trung tâm ở TP HCM để \"đảm bảo an toàn cho học sinh và thầy cô\".\n" +
                "\n" +
                "Trước thông tin ông Thủy đưa ra, các phụ huynh cho rằng \"ông Thủy đang cố tình biến chúng tôi từ nạn nhân trở thành người phá hoại\". Việc họ tụ tập đòi tiền là hành động dễ hiểu, vì trước đó Apax Leaders đã trễ hẹn hoàn phí theo cam kết. Phụ huynh tìm tới các trung tâm Apax Leaders để nói chuyện trực tiếp, hô khẩu lệnh đòi tiền chứ không đến mức \"bao vây\" như ông Thủy mô tả.\n" +
                "\n" +
                "Theo họ, doanh nghiệp của ông Thủy đã nhiều lần trễ hẹn hoàn học phí. Apax Leaders mới hoàn 20-60% tiền học phí cho phụ huynh trong hai đợt vào tháng 6 và 8/2023. Sau đó, công ty liên tiếp trễ hẹn. Đến tháng 11/2023, trung tâm này đưa ra lộ trình hoàn số tiền còn lại theo từng giai đoạn, bắt đầu với 5% vào ngày 31/12/2023.\n" +
                "\n" +
                "Tuy nhiên, trước thời điểm hoàn tiền một ngày, ông Thủy gửi thư xin lỗi đến phụ huynh và học viên tại các trung tâm về việc không thực hiện được lộ trình thanh toán. Nguyên nhân là còn nhiều khó khăn phát sinh ngoài dự kiến, khiến các trung tâm không thể hoạt động. Công ty hứa đến ngày 9/1 (tức ngày ra thông báo) sẽ đưa ra kế hoạch hoàn phí mới." + "\", // Một chuỗi với độ dài lớn hơn 255 kí tự\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is4xxClientError());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'price' < 1000
     * */
    @Test
    public void testPriceMinValueValidation() throws Exception {

        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 999,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'price' > 999,999,999
     * */
    @Test
    public void testPriceMaxValueValidation() throws Exception {
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 1000000000,\n" + // Trường 'price' lớn hơn 999999999
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'price' not a number
     * */
    @Test
    public void testNonNumericPriceValidation() throws Exception {

        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": \"abc\" \n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'code' duplicate
     * */
    @Test
    public void testDuplicateCodeValidation() throws Exception {

        String testData = "{\n" +
                "    \"code\": \"MB-1234\",\n" +
                "    \"price\": 1000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check 'id' not found
     * */
    @Test
    public void testIdNotFound() throws Exception {
        //test id not found
        String testData = "{\n" +
                "    \"code\": \"MB-001\",\n" +
                "    \"price\": 1000000,\n" +
                "    \"floor\": 1,\n" +
                "    \"cost\": 500000,\n" +
                "    \"area\": 100.0,\n" +
                "    \"description\": \"\",\n" +
                "    \"typePremises\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Mặt tiền\"\n" +
                "    },\n" +
                "    \"premisesStatus\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Chưa bàn giao\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().isBadRequest());
    }

    /*Creator: Hoàng Trần Văn Hiếu
     * Date created: 26/03/2024
     * Check success update
     * */

    @Test
    public void testSuccessfulUpdate() throws Exception {
        String testData = "{\"code\":\"MB-5678\",\"floor\":2,\"typeId\":1,\"statusId\":1,\"area\":150.5,\"description\":\"Updated description\",\"price\":2000000,\"cost\":500000}";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/premises/update/4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testData))
                .andExpect(status().is2xxSuccessful());
    }
}
