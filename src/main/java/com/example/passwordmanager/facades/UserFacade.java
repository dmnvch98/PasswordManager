package com.example.passwordmanager.facades;

import com.example.passwordmanager.converters.CredConverter;
import com.example.passwordmanager.converters.UserConverter;
import com.example.passwordmanager.dto.CredentialsDtoSafe;
import com.example.passwordmanager.dto.UserRequestDto;
import com.example.passwordmanager.dto.UserResponseDto;
import com.example.passwordmanager.models.Credential;
import com.example.passwordmanager.models.User;
import com.example.passwordmanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserService userService;
    private final UserConverter userConverter;
    private final CredConverter credConverter;

    public UserResponseDto save(final UserRequestDto userRequestDto) {
        User user = userConverter.requestDtoToUser(userRequestDto);
        User savedUser = userService.save(user);
        List<CredentialsDtoSafe> credentialsDto = new ArrayList<>();
        if (user.getCredentials() != null) {
            credentialsDto =  mapCredentials(user.getCredentials());
        }
        return userConverter.userToResponseDto(savedUser, credentialsDto);
    }

    public List<UserResponseDto> findAll() {
        return userService
                .findAll()
                .stream()
                .map(user -> userConverter.userToResponseDto(user, mapCredentials(user.getCredentials())))
                .toList();
    }

    @Cacheable(value = "usr", key = "#id")
    public UserResponseDto findById(Long id) {
        User user = userService.findById(id);
        return userConverter.userToResponseDto(user, mapCredentials(user.getCredentials()));
    }

    private List<CredentialsDtoSafe> mapCredentials(Set<Credential> credentials) {
        return credentials
                .stream()
                .map(credConverter::credToDto)
                .toList();
    }
}
