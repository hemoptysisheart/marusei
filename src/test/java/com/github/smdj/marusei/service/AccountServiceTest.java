package com.github.smdj.marusei.service;

import com.github.smdj.marusei.Launcher;
import com.github.smdj.marusei.domain.Account;
import com.github.smdj.marusei.service.params.CreateAccountParams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Launcher.class)
@Transactional
public class AccountServiceTest {
    private static final Logger log = LoggerFactory.getLogger(AccountServiceTest.class);

    @Autowired
    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
        log.debug("log");
        assertThat(accountService)
                .isNotNull();
    }

    @Test
    public void test_create() {
        // given
        String email = "aaa@aa.a";
        String nickname = "aaa";
        String password = "1234";

        CreateAccountParams createAccountParams = new CreateAccountParams(email, nickname, password);
        log.debug("createAccountParams : {}", createAccountParams);

        Instant before = Instant.now();

        // when
        Account account = accountService.create(createAccountParams);
        log.debug("account : {}", account);

        // then
        assertThat(account)
                .isNotNull()
                .extracting(Account::getEmail, Account::getNickname)
                .containsSequence(email, nickname);

        assertThat(account.getId())
                .isGreaterThan(0);

        assertThat(account.getCreatedAt())
                .isAfterOrEqualTo(before)
                .isEqualTo(account.getUpdatedAt());

    }
}