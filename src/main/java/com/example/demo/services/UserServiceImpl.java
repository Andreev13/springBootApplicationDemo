package com.example.demo.services;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;
import com.example.demo.resttemplate.MyRestTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private MyRestTemplate myRestTemplate;

    @Override
    public User getUserId(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.stream().findAny().orElse(null);
    }

    @Override
    public User addUser(User user) {
        var createUserBD = userRepository.save(user);
//        myRestTemplate.callGetRequestStab("call", "1314");
        return createUserBD;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User with id: " + id + " was delete";
//        log.info("Пользователь c id - " + id + " удален");
    }

    @Override
    public String getUserCardsById(Long id) {
        myRestTemplate.callGetRequestStab();
//        return userRepository.getUserCardById(id);
        return myRestTemplate.callGetRequestStab();
//        var userCards = new UserCards(
//                map.get("name").toString(),
//                map.get("number") != null ? Integer.parseInt(map.get("number").toString()) : 1,
//                map.get("created_date") != null ? map.get("created_date").toString() : null,
//                map.get("closed_date") != null ? map.get("closed_date").toString() : null);
//                map.get("closed_date").toString());
//        log.info(userCards.toString());
       // return userCards;
    }

//    public UserCards mappingUserCards(Map<String, Object> map) {
//        var userCards = new UserCards(
//                map.get("name").toString(),
//                map.get("number") != null?Integer.parseInt(map.get("number").toString()):0,
//                map.get("created_date") != null?map.get("created_date").toString():null,
//                map.get("closed_date") != null?map.get("closed_date").toString():null);
//                map.get("closed_date").toString());
//        log.info(userCards.toString());
//        return userCards;
//    }


}
