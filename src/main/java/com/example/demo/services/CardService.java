package com.example.demo.services;

import com.example.demo.models.Card;
import com.example.demo.models.User;

import java.util.List;

public interface CardService {
    Card getCardId(int id);
    void addCard(Card card);
    List<Card> getAllCards();
    void deleteCard(int id);
}
