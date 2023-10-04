package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.RegisterDTO;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/register")
    public String registrar(User user){
        return "register";
    }
    
    @PostMapping("/register")
    public ResponseEntity register(RegisterDTO data){
        if (this.userRepository.findByLogin(data.login())!= null) return ResponseEntity.badRequest().build();
        System.out.println(data);
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
