package com.example.passwordmanager.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serial;
import java.io.Serializable;

@Value
@Builder
@Jacksonized
public class CredentialsDtoSafe implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    Long id;
    String name;
    String website;

}
