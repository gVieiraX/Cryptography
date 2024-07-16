package com.cryptographyapi.controller;

import com.cryptographyapi.domain.Cryptography;
import com.cryptographyapi.dtos.CryptographyDTO;
import com.cryptographyapi.service.CryptographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptography")
public class CryptographyController {

    private final CryptographyService cryptographyService;

    @Autowired
    public CryptographyController(CryptographyService cryptographyService) {
        this.cryptographyService = cryptographyService;
    }

    @PostMapping
    public CryptographyDTO create(@RequestBody Cryptography cryptography) {
        Cryptography createdCryptography = cryptographyService.create(cryptography);
        return new CryptographyDTO(
                createdCryptography.getId(),
                createdCryptography.getUserDocument(),
                createdCryptography.getCreditCardToken(),
                createdCryptography.getValue()
        );
    }
    @GetMapping
    public List<CryptographyDTO> show() {
        return cryptographyService.getAllCryptography();
    }
}
