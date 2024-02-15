package com.example.passwordmanager.models;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table("users")
@Value
@Builder
@Jacksonized
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    Long id;
    String email;
    String password;
    @MappedCollection(idColumn = "user_id")
    Set<Credential> credentials;
}
