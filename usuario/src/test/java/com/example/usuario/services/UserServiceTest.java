package com.example.usuario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.usuario.entities.User;
import com.example.usuario.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    public void testCriarUsuarioComSucesso(){
        // GIVEN
        User userDummy = new User();
        userDummy.setUsername("username1");

        when(repository.findByUsername(userDummy.getUsername())).thenReturn(null);
        when(repository.save(userDummy)).thenReturn(userDummy);
        
        // WHEN
        var user = service.create(userDummy);

        // THEN
        assertEquals(userDummy, user);
    }
}
