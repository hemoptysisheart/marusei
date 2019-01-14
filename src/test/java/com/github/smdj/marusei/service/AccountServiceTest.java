package com.github.smdj.marusei.service;

import com.github.smdj.marusei.Launcher;
import com.github.smdj.marusei.domain.Account;
import com.github.smdj.marusei.domain.Credential;
import com.github.smdj.marusei.jpa.entity.AccountEntity;
import com.github.smdj.marusei.jpa.entity.CredentialEntity;
import com.github.smdj.marusei.jpa.repository.CredentialRepository;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Launcher.class)
@Transactional
public class AccountServiceTest {
    private static final Logger log = LoggerFactory.getLogger(AccountServiceTest.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private CredentialRepository credentialRepository;

    @Before
    public void setUp() throws Exception {
        log.debug("log");
        assertThat(accountService)
                .isNotNull();

        assertThat(credentialRepository)
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

        List<CredentialEntity> list = credentialRepository.findAllByAccount((AccountEntity) account);

        assertThat(list)
                .hasSize(2);

        for (CredentialEntity credentialEntity : list) {
            assertThat(credentialEntity)
                    .isNotNull()
                    .extracting(Credential::getAccount, Credential::getCreatedAt, Credential::getUpdatedAt)
                    .containsSequence(account, account.getCreatedAt(), account.getUpdatedAt());

            assertThat(credentialEntity.getId())
                    .isGreaterThan(0L);

            assertThat(credentialEntity.getPublicKey())
                    .isIn(email, nickname);

            assertThat(credentialEntity.getSecreteHash())
                    .isNotEmpty()
                    .isNotEqualTo(password);
        }

        for (String publicKey : new String[]{email, nickname}) {
            CredentialEntity credentialEntity = credentialRepository.findOneByPublicKey(publicKey);

            assertThat(credentialEntity)
                    .isNotNull()
                    .extracting(Credential::getAccount, Credential::getPublicKey)
                    .containsSequence(account, publicKey);
        }
    }

    @Test
    public void test_with_nulls() {

        // given
        CreateAccountParams createAccountParams = new CreateAccountParams(null, null, null);

        // then
        assertThatThrownBy(() -> accountService.create(createAccountParams))
                .isInstanceOf(IllegalArgumentException.class);
    }
}