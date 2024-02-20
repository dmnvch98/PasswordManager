package com.example.passwordmanager.services;

import com.example.passwordmanager.models.Credential;
import com.example.passwordmanager.repositories.CredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CredService {

    private final CredRepository credRepository;

    @CacheEvict(value = "usr", key = "#credential.userId")
    public Credential save(Credential credential) {
        return credRepository.save(credential);
    }

    public List<Credential> getCredsByIds(List<Long> ids) {
        return (List<Credential>) credRepository.findAllById(ids);
    }

    @CacheEvict(value = "usr", key = "#userId")
    public void deleteCredential(Long id, Long userId) {
        credRepository.deleteById(id);
    }
}
