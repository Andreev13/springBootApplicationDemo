package com.example.demo.services;

import com.example.demo.models.Card;
import com.example.demo.dao.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService{

    private CardRepository cardRepository;

    @Override
    public Card getCardId(int id) {
        Optional<Card> optional = cardRepository.findById(id);
        return optional.stream().findAny().orElse(null);
    }

    @Override
    public void addCard(Card card) {
        cardRepository.save(card);
//        cardRepository.addCardForUser()
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void deleteCard(int id) {
        cardRepository.deleteById(id);
    }
}
