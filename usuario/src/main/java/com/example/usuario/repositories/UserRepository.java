package com.example.usuario.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuario.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByUsername(String username);
}
