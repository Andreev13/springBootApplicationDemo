package com.example.demo.controllers;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void givenUser_whenAa_thenStatus201andReturnUser() throws Exception{
        User user = new User(1L,"Dulyz", 43, "duby");

        mockMvc.perform(
                post("/users")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("Dulyz"))
                .andExpect(jsonPath("$.age").value(43))
                .andExpect(jsonPath("$.city").value("duby"));
    }


    private User createUser(Long id, String name, int age, String city){
        return  userRepository.save(new User(id, name, age, city));
    }

//    @Test
//    public void testSimple(){
//    }
}
