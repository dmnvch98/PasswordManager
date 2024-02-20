package com.example.passwordmanager.facades;

import com.example.passwordmanager.converters.CredConverter;
import com.example.passwordmanager.dto.CredentialsDtoSafe;
import com.example.passwordmanager.models.Credential;
import com.example.passwordmanager.services.CredSearchService;
import com.example.passwordmanager.services.CredService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CredFacade {

    private final CredService credService;
    private final CredSearchService credSearchService;
    private final CredConverter credConverter;

    public CredentialsDtoSafe save(final Credential credential) {
        final Credential savedCredential = credService.save(credential.withCreatedAt(LocalDateTime.now()));
        final CredentialsDtoSafe mappedCredential = credConverter.credToDto(savedCredential);
        credSearchService.index(mappedCredential);
        return mappedCredential;
    }

    public List<Credential> findCredentialsByDescription(String description) {
        List<Long> ids = credSearchService.findIdsByDescription(description);
        if (ids != null && !ids.isEmpty()) {
            return credService.getCredsByIds(ids);
        }
        return Collections.emptyList();
    }

}
