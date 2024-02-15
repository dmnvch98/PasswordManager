package com.example.passwordmanager.controllers;

import com.example.passwordmanager.models.Credential;
import com.example.passwordmanager.services.CredService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/creds")
@RestController
@RequiredArgsConstructor
public class CredController {

    private final CredService credService;

    @PostMapping
    public ResponseEntity<Credential> save(@RequestBody Credential credential) {
        Credential savedCredential = credService.save(credential);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCredential);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Long userId = 1L;
        credService.deleteCredential(id, userId);
        return ResponseEntity.noContent().build();
    }
}
