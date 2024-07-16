package com.cryptographyapi.response;

import com.cryptographyapi.domain.Cryptography;

public class CryptographyResponse {
    private Cryptography cryptography;

    public CryptographyResponse(Cryptography cryptography) {
        this.cryptography = cryptography;
    }

    public Cryptography getCryptography() {
        return cryptography;
    }

    public void setCryptography(Cryptography cryptography) {
        this.cryptography = cryptography;
    }
}
