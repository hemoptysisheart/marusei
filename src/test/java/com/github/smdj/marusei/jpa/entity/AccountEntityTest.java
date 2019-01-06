package com.github.smdj.marusei.jpa.entity;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountEntityTest {
    public final static Logger log = LoggerFactory.getLogger(AccountEntityTest.class);

    @Test
    public void test_new() {
        // given: 테스트 하기 위해 필요한 데이터
        // when: 로직
        // then : 결과를 검사
        String email = "aaa@aaa.a";
        String nickname = "aaa";
        Instant createdAt = Instant.now();

        log.debug("given => email = {}, nickname = {}, createdAt = {}", email, nickname, createdAt);

        // when
        AccountEntity accountEntity = new AccountEntity(email, nickname, createdAt);
        log.debug("when => accountEntity = {}", accountEntity);

        // then
        assertThat(accountEntity)
                .isNotNull()
                .extracting(AccountEntity::getId, AccountEntity::getEmail, AccountEntity::getNickname, AccountEntity::getCreatedAt, AccountEntity::getUpdatedAt)
                .containsSequence(0, email, nickname, createdAt, createdAt);

    }
}