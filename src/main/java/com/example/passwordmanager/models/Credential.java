package com.example.passwordmanager.models;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("credentials")
@Value
@Builder
public class Credential {

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
