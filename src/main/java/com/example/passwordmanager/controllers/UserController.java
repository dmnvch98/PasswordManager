package com.example.passwordmanager.controllers;

import com.example.passwordmanager.models.User;
import com.example.passwordmanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody final User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
