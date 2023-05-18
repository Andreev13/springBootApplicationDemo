package com.example.demo.services;

import com.example.demo.dto.UserCards;
import com.example.demo.models.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getUserId(Long id);
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    UserCards getUserCardsById(Long id);
//    UserCards mappingUserCards(Map<String, Object> map);
}
