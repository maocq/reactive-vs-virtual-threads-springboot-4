package com.maocq.virtualthreads.domain.model.account.gateways;

import com.maocq.virtualthreads.domain.model.account.Account;

public interface AccountRepository {

    Account findById(int id);
    Account update(Account account);
}
