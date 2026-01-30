package com.example.backend;

import com.example.backend.model.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.backend.model.entity.User;
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
public class UserTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    void getUser() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/user/1111"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(1111L, receivedJson.get("clientId").longValue());
        assertEquals("Michael", receivedJson.get("firstName").textValue());
        assertEquals("Scott", receivedJson.get("lastName").textValue());
        assertEquals(49, receivedJson.get("age").intValue());
        assertEquals(176.0, receivedJson.get("height").floatValue());
        assertEquals(170.0, receivedJson.get("weight").floatValue());
        assertEquals("111", receivedJson.get("password").textValue());
    }

    @Test
    void addUser() throws Exception{

        ObjectNode userJson = objectMapper.createObjectNode();
        userJson.put("clientId", 2020L);
        userJson.put("firstName", "Vida");
        userJson.put("lastName", "Fit");
        userJson.put("age", 22);
        userJson.put("height", 180.0);
        userJson.put("weight", 160.0);
        userJson.put("password", "202");

        MockHttpServletResponse response = mockMvc.perform(
                        post("/user").
                                contentType("application/json").
                                content(userJson.toString()))
                .andReturn().getResponse();

        // assert HTTP code of response is 200 OK
        assertEquals(200, response.getStatus());

        // Assert student with id 8888 exists in our repository and then get the student object
        assertTrue(userRepository.findById(2020L).isPresent());
        User addedUser = userRepository.findById(2020L).get();

        // Assert the details of the students are correct
        assertEquals(2020L, addedUser.getClientId());
        assertEquals("Vida", addedUser.getFirstName());
        assertEquals("Fit", addedUser.getLastName());
        assertEquals(22, addedUser.getAge());
        assertEquals(180.0, addedUser.getHeight());
        assertEquals(160.0, addedUser.getWeight());
        assertEquals("202", addedUser.getPassword());
    }

    @Test
    void deleteUser() throws Exception{

        MockHttpServletResponse response = mockMvc.perform(
                        delete("/user/1010").
                                contentType("application/json"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(userRepository.findById(1010L).isEmpty());
    }

    @Test
    void updateUser() throws Exception{
        ObjectNode userJson = objectMapper.createObjectNode();
        userJson.put("firstName", "Vida");
        userJson.put("lastName", "Fit");

        MockHttpServletResponse response = mockMvc.perform(
                        put("/user/2222").
                                contentType("application/json").
                                content(userJson.toString()))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        assertTrue(userRepository.findById(2222L).isPresent());
        User updUser = userRepository.findById(2222L).get();


        assertEquals(2222L, updUser.getClientId());
        assertEquals("Vida", updUser.getFirstName());
        assertEquals("Fit", updUser.getLastName());

    }

}
