package com.example.passwordmanager.converters;

import com.example.passwordmanager.dto.CredentialsDtoSafe;
import com.example.passwordmanager.dto.UserRequestDto;
import com.example.passwordmanager.dto.UserResponseDto;
import com.example.passwordmanager.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserConverter {

    User requestDtoToUser(UserRequestDto userRequestDto);

    @Mapping(source = "credentialsDto", target = "credentials")
    UserResponseDto userToResponseDto(User user, List<CredentialsDtoSafe> credentialsDto);

}
