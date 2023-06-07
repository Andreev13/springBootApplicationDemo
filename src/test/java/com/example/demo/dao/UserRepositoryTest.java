package com.example.demo.dao;

import com.example.demo.models.Card;
import com.example.demo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;


    @Test
    void getUserCardById() throws Exception{
//        userRepository.save(new User(1L, "Igor", 28, "SPB", null));
        cardRepository.save(
                new Card(1L, 14929, "13.11.2020", "13.11.2023",
                        new User(1L, "Igor", 28, "SPB", null)));

        var user = userRepository.getUserCardById(1L);
        assertNotNull(user);
        assertEquals("Igor", user.getName());
    }
}