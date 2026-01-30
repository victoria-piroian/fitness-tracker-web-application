package com.example.backend;

import com.example.backend.model.entity.UserSleepKey;
import com.example.backend.model.repository.SleepRepository;
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

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SleepTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SleepRepository sleepRepository;

    @Test
    void getSleep() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/sleep/1111/December2,2022"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);


        assertEquals(6.5, Math.round(receivedJson.get("duration").floatValue()),1);
        assertEquals(4, receivedJson.get("restScore").floatValue());
        assertEquals(true, receivedJson.get("dream").asBoolean());
        assertEquals(true, receivedJson.get("alarmWakeUp").asBoolean());
        assertEquals(1,receivedJson.get("numNaps").floatValue());
    }
    @Test
    void deleteSleep() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        delete("/sleep/2222/December3,2022").
                                contentType("application/json"))
                .andReturn().getResponse();

        UserSleepKey sleepKey = new UserSleepKey(2222L,"December3,2022");
        assertEquals(200, response.getStatus());
        assertTrue(sleepRepository.findById(sleepKey).isEmpty());
    }

}


