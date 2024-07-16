package com.cryptographyapi.repository;

import com.cryptographyapi.domain.Cryptography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptographyRepository extends JpaRepository<Cryptography,Long> {

}
