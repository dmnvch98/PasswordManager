package com.example.passwordmanager.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Value
@Builder
public class UserResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    Long id;
    String email;
    Set<CredentialsDtoSafe> credentials;
}
