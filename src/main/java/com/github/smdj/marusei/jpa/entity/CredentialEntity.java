package com.github.smdj.marusei.jpa.entity;

import com.github.smdj.marusei.domain.Account;
import com.github.smdj.marusei.domain.Credential;

import java.time.Instant;
import java.util.Objects;

public class CredentialEntity implements Credential {
    private long id;
    private Account account;
    private String publicKey;
    private String screteHash;
    private Instant createdAt;
    private Instant updatedAt;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public String getPublicKey() {
        return publicKey;
    }

    @Override
    public String getScreteHash() {
        return screteHash;
    }

    @Override
    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (id <= 0) return false;
        CredentialEntity that = (CredentialEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
