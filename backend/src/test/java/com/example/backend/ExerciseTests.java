package com.example.backend;

import com.example.backend.model.entity.UserExerciseKey;
import com.example.backend.model.repository.ExerciseRepository;
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
public class ExerciseTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Test
    void getExercise() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/exercise/1111/1/December2,2022"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);

        assertEquals("arm day", receivedJson.get("workoutName").textValue());
        assertEquals(2.5, Math.round(receivedJson.get("duration").floatValue()),1);
        assertEquals(3, receivedJson.get("satisfaction").intValue());
    }

    @Test
    void deleteExercise() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        delete("/exercise/2222/1/December2,2022").
                                contentType("application/json"))
                .andReturn().getResponse();

        UserExerciseKey exerciseKey = new UserExerciseKey(2222L, 1L,"December2,2022");
        assertEquals(200, response.getStatus());
        assertTrue(exerciseRepository.findById(exerciseKey).isEmpty());
    }
}
