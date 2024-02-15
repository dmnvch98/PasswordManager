package com.example.passwordmanager.models;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table("credentials")
@Value
@Builder
public class Credential implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    Long id;
    String name;
    String website;
    String username;
    String password;
    LocalDateTime createdAt;
    @Column("user_id")
    Long userId;
}
