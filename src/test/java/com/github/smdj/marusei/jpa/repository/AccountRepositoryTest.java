package com.github.smdj.marusei.jpa.repository;

import com.github.smdj.marusei.Launcher;
import com.github.smdj.marusei.jpa.entity.AccountEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Launcher.class)
@Rollback
public class AccountRepositoryTest {
    private final static Logger log = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {
        assertThat(accountRepository)
                .isNotNull();
    }

    @Test
    public void test_findAll() {
        // when
        List<AccountEntity> list = accountRepository.findAll();
        log.debug("accountRepository list = {}", list);

        // then
        assertThat(list)
                .isEmpty();
    }
}