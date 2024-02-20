package com.example.passwordmanager.converters;

import com.example.passwordmanager.dto.CredentialsDtoSafe;
import com.example.passwordmanager.models.Credential;
import org.mapstruct.Mapper;

@Mapper
public interface CredConverter {

    CredentialsDtoSafe credToDto(Credential credential);
}
