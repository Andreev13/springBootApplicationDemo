package com.example.demo.services;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    User getUserId(Long id);
    User addUser(User user);
    List<User> getAllUsers();
    String deleteUser(Long id);
    String getUserCardsById(Long id);
//    UserCards mappingUserCards(Map<String, Object> map);
}
