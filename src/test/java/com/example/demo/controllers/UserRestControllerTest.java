package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserRestControllerTest {

    private MockMvc mockMvc;
    private UserService userService;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        userService = mock(UserService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserRestController(userService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void addNewUser() throws Exception{
        var user = new User(1L, "Igor", 28, "SPB", null);
        when(userService.addUser(any())).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(user)));

    }

    @Test
    void getAllUser() throws Exception {
        var users = List.of(
                new User(1L, "Igor", 28, "SPB", null),
                new User(2L, "Vika", 24, "SPB", null),
                new User(3L, "Nikita", 23, "Omsk", null),
                new User(4L, "Bob", 46, "Dubai", null),
                new User(5L, "Jhon", 34, "Loh", null));

        when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(get("/users"))
                .andExpect(content().json(objectMapper.writeValueAsString(users)));
    }

    @Test
    void getUser() throws Exception{
        var user = new User(1L, "Igor", 28, "SPB", null);

        when(userService.getUserId(any())).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(content().json(objectMapper.writeValueAsString(user)));
        verify(userService, times(1)).getUserId(1L);
    }

    @Test
    void deleteUserById() {
    }
}