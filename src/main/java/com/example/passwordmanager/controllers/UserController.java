package com.example.passwordmanager.controllers;

import com.example.passwordmanager.dto.UserRequestDto;
import com.example.passwordmanager.dto.UserResponseDto;
import com.example.passwordmanager.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto save(@RequestBody final UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

    @GetMapping
    public List<UserResponseDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
