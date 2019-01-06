package com.github.smdj.marusei.jpa.entity;

import com.github.smdj.marusei.domain.Account;

import java.time.Instant;

public class AccountEntity implements Account {

    private int id;
    private String email;
    private String nickname;
    private Instant createdAt;
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
