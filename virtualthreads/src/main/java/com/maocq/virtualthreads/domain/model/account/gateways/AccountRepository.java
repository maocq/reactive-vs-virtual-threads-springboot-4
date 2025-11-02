package com.maocq.virtualthreads.domain.model.account.gateways;

import com.maocq.virtualthreads.domain.model.account.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(int id);
    Account update(Account account);
}
