package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.dao.UserRepository;
import com.lpnu.spring.pizzeria_spring_webapp.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testGetAllUsers() {
        List<User> userList = Arrays.asList(new User(), new User(), new User());
        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getAllUsers();

        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void testSaveUser() {
        User user = new User();

        userService.saveUser(user);

        verify(userRepository).save(user);
    }

    @Test
    public void testDeleteUser() {
        String username = "testUser";

        userService.deleteUser(username);

        verify(userRepository).deleteById(username);
    }

    @Test
    public void testGetUserByUsername() {
        String username = "testUser";
        User user = new User();
        when(userRepository.getReferenceById(username)).thenReturn(user);

        User result = userService.getUserByUsername(username);

        Assertions.assertEquals(user, result);
    }
}
