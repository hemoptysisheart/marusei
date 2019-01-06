package com.github.smdj.marusei.jpa.entity;

import com.github.smdj.marusei.domain.Account;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "Account")
@Table(name = "account", uniqueConstraints = {@UniqueConstraint(name = "UQ_ACCOUNT_EMAIL", columnNames = "email"),
        @UniqueConstraint(name = "UQ_ACCOUNT_NICKNAME", columnNames = "nickname")})
public class AccountEntity implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private int id;
    @Column(name = "email", unique = true, nullable = false, updatable = false)
    private String email;
    @Column(name = "nickname", unique = true, nullable = false, updatable = false)
    private String nickname;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getNickname() {
        return nickname;
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
        AccountEntity that = (AccountEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
