package com.example.passwordmanager.controllers;

import com.example.passwordmanager.dto.CredentialsDtoSafe;
import com.example.passwordmanager.facades.CredFacade;
import com.example.passwordmanager.models.Credential;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/creds")
@RestController
@RequiredArgsConstructor
public class CredController {

    private final CredFacade credFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CredentialsDtoSafe save(@RequestBody Credential credential) {
        return credFacade.save(credential);
    }

    @GetMapping()
    public List<Credential> findAllByDescription(@RequestParam(required = false) String description) {
        return credFacade.findCredentialsByDescription(description);
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id) {
//        Long userId = 1L;
//        credService.deleteCredential(id, userId);
//    }
}
