package com.example.usuario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;



import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuario.entities.User;
import com.example.usuario.repositories.UserRepository;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class UserServiceTestI {

    @Autowired
    UserService service;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll(); // Limpa o banco de dados antes de cada teste
    }

    @Test
    public void criarUsuarioComSucesso() {  
        // GIVEN
        User userDummy = new User();
        userDummy.setEmail("email@gmail.com");
        userDummy.setUsername("username");
        userDummy.setPassword("senha");

        // WHEN
        var userCriado = service.create(userDummy);

        // THEN
        assertNotNull(userCriado);
        assertNotNull(userCriado.getId());
        assertEquals(userDummy.getUsername(), userCriado.getUsername());
    }

    @Test
    public void listarUsuarios() {
        // GIVEN
        User user1 = new User("username1", "email1@gmail.com", "senha1");
        User user2 = new User("username2", "email2@gmail.com", "senha2");
        userRepository.save(user1);
        userRepository.save(user2);

        // WHEN
        List<User> usuarios = service.list();

        // THEN
        assertEquals(2, usuarios.size());
        assertEquals(user1.getUsername(), usuarios.get(0).getUsername());
        assertEquals(user2.getUsername(), usuarios.get(1).getUsername());
    }

    @Test
    public void atualizarUsuario() {
        // GIVEN
        User user = new User("username", "email@gmail.com", "senha");
        userRepository.save(user);

        user.setUsername("updatedUsername");

        // WHEN
        User usuarioAtualizado = service.update(user);

        // THEN
        assertNotNull(usuarioAtualizado);
        assertEquals("updatedUsername", usuarioAtualizado.getUsername());
    }

    @Test
    public void removerUsuario() {
        // GIVEN
        User user = new User("username", "email@gmail.com", "senha");
        userRepository.save(user);

        // WHEN
        service.delete(user.getId());

        // THEN
        assertThrows(NoSuchElementException.class, () -> userRepository.findById(user.getId()).orElseThrow());
    }
}
