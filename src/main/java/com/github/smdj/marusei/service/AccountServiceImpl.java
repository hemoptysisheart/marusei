package com.github.smdj.marusei.service;

import com.github.smdj.marusei.domain.Account;
import com.github.smdj.marusei.service.params.CreateAccountParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class AccountServiceImpl implements AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public Account create(CreateAccountParams createAccountParams) {
        if (log.isTraceEnabled()) {
            log.trace("createAccountParams : {}", createAccountParams);
        }
        return null;
    }
}
