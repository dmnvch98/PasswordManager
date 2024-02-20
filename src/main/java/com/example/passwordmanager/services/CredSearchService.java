package com.example.passwordmanager.services;

import com.example.passwordmanager.dto.CredentialsDtoSafe;
import com.example.passwordmanager.repositories.CredSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CredSearchService {

    private final CredSearchRepository credSearchRepository;

    public void index(final CredentialsDtoSafe credential) {
        credSearchRepository.index(credential);
    }

    public List<Long> findIdsByDescription(String description) {
        return credSearchRepository.findByDescription(description);
    }
}
