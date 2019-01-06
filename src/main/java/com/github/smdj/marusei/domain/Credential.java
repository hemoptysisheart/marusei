package com.github.smdj.marusei.domain;

import java.time.Instant;

public interface Credential {
    long getId();

    Account getAccount();

    String getPublicKey();

    String getScreteHash();

    Instant getCreatedAt();

    Instant getUpdatedAt();
}
