package com.cryptographyapi.dtos;


public record CryptographyDTO(Long id,
     String encryptedUserDocument,
     String encryptedCreditCardToken,
     Long value
     ){}
