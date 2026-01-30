package com.example.backend;

import com.example.backend.model.entity.*;
import com.example.backend.model.repository.ProgressRepository;
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
public class ProgressTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProgressRepository progressRepository;

    @Test
    void getProgress() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/progress/1111/1"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);

        assertEquals("I want to improve my sleep schedule and get over 6 hours more regularly.", receivedJson.get("goal").textValue());
        assertEquals(4, receivedJson.get("progressScore").floatValue());
        assertEquals("I have been going to bed a lot earlier and feel much more rested!", receivedJson.get("reflection").textValue());
    }

    @Test
    void deleteProgress() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        delete("/progress/1111/1").
                                contentType("application/json"))
                .andReturn().getResponse();

        UserProgressKey progressKey = new UserProgressKey(1111L,1L);
        assertEquals(200, response.getStatus());
        assertTrue(progressRepository.findById(progressKey).isEmpty());
    }
}

