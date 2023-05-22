package com.example.demo.controllers;

import com.example.demo.dto.UserCards;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;

    @PostMapping(value = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User addNewUser(@RequestBody User user) {
        userService.addUser(user);
        log.info("Добавлен новый пользователь: " + user.toString());
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserId(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return "Пользователь c id - " + id + " удален";
    }

//    @GetMapping("/userscard/{id}")
//    public String getUserCard(@PathVariable Long id){
////        log.info(String.valueOf(id));
//        return userService.getUserCardsById(id);
//    }

}
