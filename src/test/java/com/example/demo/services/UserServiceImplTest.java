package com.example.demo.services;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;
import com.example.demo.resttemplate.MyRestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class UserServiceImplTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        var myRestTemplate = mock(MyRestTemplate.class);
        userService = new UserServiceImpl(userRepository, myRestTemplate);

        when(userRepository.findById(any())).thenReturn(Optional.of(new User(1L, "Igor", 28, "SPB", null)));
        when(userRepository.save(any())).thenReturn(new User(1L, "Igor", 28, "SPB", null));
        when(userRepository.findAll()).thenReturn(List.of(
                new User(1L, "Igor", 28, "SPB", null),
                new User(2L, "Vika", 24, "SPB", null),
                new User(3L, "Nikita", 23, "Omsk", null),
                new User(4L, "Bob", 46, "Dubai", null),
                new User(5L, "Jhon", 34, "Loh", null)));
    }


//    @Test
//    void addUser() throws Exception {
//        when(userRepository.getUserCardById(any()))
//                .thenReturn(new UserCards("Igor", 13214, "13.11.2020", " 13.11.2023"));
//
//        var user = userService.getUserCardsById(1L);
//        System.out.println(user);
//    }

    @Test
    void getUserId() throws Exception {
        var user = userService.getUserId(1L);
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("Igor", user.getName());
        assertEquals(28, user.getAge());
        assertEquals("SPB", user.getCity());
        verify(userRepository, times(1)).findById(1L);

    }

    @Test
    void testAddUser() {
        var user = userService.addUser(new User(1L, "Igor", 28, "SPB", null));
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("Igor", user.getName());
        assertEquals(28, user.getAge());
        assertEquals("SPB", user.getCity());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void getAllUsers() {
        var users = userService.getAllUsers();
        assertNotNull(users);
        assertEquals(5, users.size());
        assertEquals(3L, users.get(2).getId());
        assertEquals("Vika", users.get(1).getName());
        assertEquals("Omsk", users.get(2).getCity());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void deleteUser() {
        var id = 1L;
        userService.deleteUser(id);
        verify(userRepository, times(1)).deleteById(id);
    }

}