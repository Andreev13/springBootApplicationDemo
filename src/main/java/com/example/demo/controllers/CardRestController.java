package com.example.demo.controllers;

import com.example.demo.models.Card;
import com.example.demo.models.User;
import com.example.demo.services.CardServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class CardRestController {

    private CardServiceImpl cardService;

    @PostMapping(value = "/cards",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Card addNewCard(@RequestBody Card card) {
        log.info("Добавлена новая карта: " + card.toString());
        cardService.addCard(card);
        return card;
    }

    @GetMapping("/cards")
    public List<Card> getAllCards() {
        log.info(cardService.getAllCards().toString());
        return cardService.getAllCards();
    }

    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable int id){
        return cardService.getCardId(id);
    }

    @DeleteMapping("/cards/{id}")
    public String deleteCardById(@PathVariable int id){
        log.info("Card c id - " + id + " удалена");
        cardService.deleteCard(id);
        return "Card c id - " + id + " удалена";
    }
}
