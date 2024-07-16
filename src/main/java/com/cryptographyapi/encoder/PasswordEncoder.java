package com.cryptographyapi.encoder;

import com.cryptographyapi.domain.Cryptography;

public interface PasswordEncoder {
    String encode (Cryptography cryptography);

    boolean matches(Cryptography rawPassword, String encodedPassword);

    default boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}
