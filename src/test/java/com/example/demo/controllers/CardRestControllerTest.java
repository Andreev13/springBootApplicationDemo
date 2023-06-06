package com.example.demo.controllers;

import com.example.demo.dao.CardRepository;
import com.example.demo.models.Card;
import com.example.demo.services.CardService;
import com.example.demo.services.CardServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

class CardRestControllerTest {

    private MockMvc mockMvc;
    private CardService cardService;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        var card = new Card(1L, 14929, "13.11.2020", "13.11.2023");
        var repository = mock(CardRepository.class);
        when(repository.findById(1)).thenReturn(Optional.of(card));
        cardService = new CardServiceImpl(repository);
        mockMvc = MockMvcBuilders.standaloneSetup(new CardRestController(cardService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void addNewCard() throws Exception {
        var card = new Card(1L, 14929, "13.11.2020", "13.11.2023");

        mockMvc.perform(post("/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(card)))
                .andDo(print())
                .andExpect(content().json(objectMapper.writeValueAsString(card)));
//        verify(cardService, times(1)).addCard(card);

    }

    @Test
    void getAllCards() throws Exception {
        var cards = List.of(
                new Card(1L, 14929, "13.11.2020", "13.11.2023"),
                new Card(2L, 32413, "14.11.2020", "14.11.2023"),
                new Card(3L, 53233, "15.11.2020", "15.11.2023"),
                new Card(4L, 83188, "16.11.2020", "16.11.2023"),
                new Card(5L, 74312, "17.11.2020", "17.11.2023"));

        when(cardService.getAllCards()).thenReturn(cards);

        mockMvc.perform(get("/cards"))
                .andExpect(content().json(objectMapper.writeValueAsString(cards)));
//        verify(cardService, times(1)).getAllCards();
    }

    @Test
    void getCard() throws Exception {
        Card card = new Card(1L, 14929, "13.11.2020", "13.11.2023");

//        when(cardService.getCardId(any())).thenReturn(card);

        mockMvc.perform(get("/cards/1"))
                .andExpect(content().json(objectMapper.writeValueAsString(card)));

//        verify(cardService, times(1)).getCardId(1);


    }

    @Test
    void deleteCardById() throws Exception {
        var id = 1;
        mockMvc.perform(delete("/cards/" + id))
                .andExpect(content().string("Card c id - " + id + " delete"));
    }
}