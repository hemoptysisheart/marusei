package com.github.smdj.marusei.jpa.repository;

import com.github.smdj.marusei.jpa.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
}
