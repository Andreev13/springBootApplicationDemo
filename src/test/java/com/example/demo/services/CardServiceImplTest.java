package com.example.demo.services;

import com.example.demo.dao.CardRepository;
import com.example.demo.models.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CardServiceImplTest {

    private CardRepository repository;
    private CardService service;

    @BeforeEach
    public void setUp() throws Exception {
        repository = mock(CardRepository.class);
        service = new CardServiceImpl(repository);

    }

    @Test
    void getCardId() {
        when(repository.findById(any()))
                .thenReturn(Optional.of(new Card(1L, 14929, "13.11.2020", "13.11.2023")));

        var id = 1;
        var card = service.getCardId(id);

        assertEquals(14929, card.getNumber());
        verify(repository, times(1)).findById(id);

    }

    @Test
    void addCard() {
        var card = new Card(1L, 14929, "13.11.2020", "13.11.2023");

        service.addCard(card);
        verify(repository, times(1)).save(card);
    }

    @Test
    void getAllCards() {
        when(repository.findAll()).thenReturn(List.of(
                new Card(1L, 14929, "13.11.2020", "13.11.2023"),
                new Card(2L, 32413, "14.11.2020", "14.11.2023"),
                new Card(3L, 53233, "15.11.2020", "15.11.2023"),
                new Card(4L, 83188, "16.11.2020", "16.11.2023"),
                new Card(5L, 74312, "17.11.2020", "17.11.2023")
        ));

        var cards = service.getAllCards();
        assertNotNull(cards);
        assertEquals(5, cards.size());
        assertEquals(1L, cards.get(0).getId());
        assertEquals("15.11.2020", cards.get(2).getCreatedDate());
    }

    @Test
    void deleteCard() {
        var id = 1;
        service.deleteCard(id);

        verify(repository, times(1)).deleteById(id);
    }
}