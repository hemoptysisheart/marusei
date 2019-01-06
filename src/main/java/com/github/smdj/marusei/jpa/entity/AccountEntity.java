package com.github.smdj.marusei.jpa.entity;

import com.github.smdj.marusei.domain.Account;

import javax.persistence.*;
import java.time.Instant;
import java.util.StringJoiner;

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

    public AccountEntity(String email, String nickname, Instant createdAt) {
        if (email == null) {
            throw new IllegalArgumentException("email is null");
        }
        if (nickname == null) {
            throw new IllegalArgumentException("nickname is null");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("createdAt is null");
        }
        this.email = email;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", AccountEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("email='" + email + "'")
                .add("nickname='" + nickname + "'")
                .add("createdAt=" + createdAt)
                .add("updatedAt=" + updatedAt)
                .toString();
    }
}
