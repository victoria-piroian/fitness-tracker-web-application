package com.example.backend;

import com.example.backend.model.entity.UserMealKey;
import com.example.backend.model.repository.DietRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DietTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DietRepository dietRepository;

    @Test
    void getDiet() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/diet/1111/Breakfast/December2,2022"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);

        assertEquals("Eggs and toast", receivedJson.get("mealName").textValue());
        assertEquals(300, receivedJson.get("calories").floatValue());
        assertEquals(20.6, Math.round(receivedJson.get("sugar").floatValue()),1);
        assertEquals(34.5, Math.round(receivedJson.get("carbs").floatValue()), 1);
        assertEquals(19.5, Math.round(receivedJson.get("protein").floatValue()),1);
        assertEquals(12.7, Math.round(receivedJson.get("fat").floatValue()),1);
    }
    @Test
    void deleteDiet() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        delete("/diet/1111/Breakfast/December2,2022").
                                contentType("application/json"))
                .andReturn().getResponse();

        UserMealKey dietKey = new UserMealKey(1111L, "Breakfast","December2,2022");
        assertEquals(200, response.getStatus());
        assertTrue(dietRepository.findById(dietKey).isEmpty());
    }
}
