package com.cryptographyapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cryptography")
public class Cryptography {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true,name = "userDocument")
    private String userDocument;
    @Column(nullable = false, unique = true,name = "creditCardToken")
    private String creditCardToken;
    @Column(nullable = false, unique = true, name = "value" )
    private Long value;

    public Cryptography() {}


    public Cryptography(String userDocument, String creditCardToken, Long value) {
        this.userDocument = userDocument;
        this.creditCardToken = creditCardToken;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
