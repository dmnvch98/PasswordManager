package com.example.passwordmanager.repositories;

import com.example.passwordmanager.models.Credential;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CredRepository extends CrudRepository<Credential, Long> {
}
