package com.github.smdj.marusei.domain;

import java.time.Instant;

public interface Account {
    int getId();

    String getEmail();

    String getNickname();

    Instant getCreatedAt();

    Instant getUpdatedAt();

}
