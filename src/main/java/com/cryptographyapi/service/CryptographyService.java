package com.cryptographyapi.service;

import com.cryptographyapi.domain.Cryptography;
import com.cryptographyapi.dtos.CryptographyDTO;
import com.cryptographyapi.repository.CryptographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptographyService {

    private final CryptographyRepository cryptographyRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public CryptographyService(CryptographyRepository cryptographyRepository, BCryptPasswordEncoder encoder) {
        this.cryptographyRepository = cryptographyRepository;
        this.encoder = encoder;
    }

    public Cryptography create(Cryptography cryptography) {
        Cryptography newCryptography = new Cryptography(cryptography.getUserDocument(), cryptography.getCreditCardToken(), cryptography.getValue());
        return cryptographyRepository.save(newCryptography);
    }

    public CryptographyService(CryptographyRepository cryptographyRepository) {
        this.cryptographyRepository = cryptographyRepository;
        this.encoder = new BCryptPasswordEncoder(10); // Exemplo de força 10
    }

    public List<CryptographyDTO> getAllCryptography() {
        List<Cryptography> cryptographyList = cryptographyRepository.findAll();
        List<CryptographyDTO> cryptographyDTOList = new ArrayList<>();

        for (Cryptography cryptography : cryptographyList) {
            String encryptedUserDocument = encoder.encode(cryptography.getUserDocument());
            String encryptedCreditCardToken = encoder.encode(cryptography.getCreditCardToken());

            CryptographyDTO cryptographyDTO = new CryptographyDTO(
                    cryptography.getId(),
                    encryptedUserDocument,
                    encryptedCreditCardToken,
                    cryptography.getValue()
            );

            cryptographyDTOList.add(cryptographyDTO);
        }

        return cryptographyDTOList;
    }
}