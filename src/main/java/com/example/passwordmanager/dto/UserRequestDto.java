package com.example.passwordmanager.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UserRequestDto {

    Long id;
    String email;
    String password;
}
