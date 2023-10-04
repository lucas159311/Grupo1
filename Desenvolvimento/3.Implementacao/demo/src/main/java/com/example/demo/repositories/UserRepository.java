package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.User;


public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
