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
    @Column(name = "screte_hash", nullable = false, updatable = false)
    private String screteHash;
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createdAt;
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public CredentialEntity() {
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
