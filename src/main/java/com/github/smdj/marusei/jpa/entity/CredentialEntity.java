package com.github.smdj.marusei.jpa.entity;

import com.github.smdj.marusei.domain.Account;
import com.github.smdj.marusei.domain.Credential;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity(name = "Credential")
@Table(name = "credential",
        uniqueConstraints = @UniqueConstraint(name = "UQ_CREDENTIAL_PUBLIC_KEY", columnNames = "public_key"),
        indexes = @Index(name = "FK_CREDENTIAL_PK_ACCOUNT", columnList = "account ASC"))
public class CredentialEntity implements Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;
    @ManyToOne(targetEntity = AccountEntity.class)
    @JoinColumn(name = "account", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_CREDENTIAL_PK_ACCOUNT"), referencedColumnName = "id")
    private Account account;
    @Column(name = "public_key", unique = true, nullable = false, updatable = false)
    private String publicKey;
    @Column(name = "secret_hash", nullable = false, updatable = false)
    private String secretHash;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    private CredentialEntity() {
    }

    public CredentialEntity(Account account, String publicKey, String secretHash, Instant createdAt) {
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        }
        if (publicKey == null) {
            throw new IllegalArgumentException("publicKey is null");
        }
        if (secretHash == null) {
            throw new IllegalArgumentException("secretHash is null");
        }
        this.account = account;
        this.publicKey = publicKey;
        this.secretHash = secretHash;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public CredentialEntity(Account account, String publicKey, String secreteHash, Instant createdAt) {
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        }
        if (publicKey == null) {
            throw new IllegalArgumentException("publicKey is null");
        }
        if (secreteHash == null) {
            throw new IllegalArgumentException("secreteHash is null");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("createdAt is null");
        }

        this.account = account;
        this.publicKey = publicKey;
        this.secreteHash = secreteHash;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

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
    public String getSecretHash() {
        return secretHash;
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
