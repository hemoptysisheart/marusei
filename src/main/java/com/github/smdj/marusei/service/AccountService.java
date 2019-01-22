package com.github.smdj.marusei.service;

import com.github.smdj.marusei.domain.Account;
import com.github.smdj.marusei.service.params.CreateAccountParams;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountService {
    Account create(CreateAccountParams createAccountParams);
}
