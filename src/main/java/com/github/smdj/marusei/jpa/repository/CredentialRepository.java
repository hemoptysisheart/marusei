package com.github.smdj.marusei.jpa.repository;

import com.github.smdj.marusei.jpa.entity.AccountEntity;
import com.github.smdj.marusei.jpa.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
    List<CredentialEntity> findAllByAccount(AccountEntity account);

    CredentialEntity findOneByPublicKey(String publicKey);
}
