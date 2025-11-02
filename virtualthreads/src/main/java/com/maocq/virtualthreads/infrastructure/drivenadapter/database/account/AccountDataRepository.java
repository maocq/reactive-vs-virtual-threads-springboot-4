package com.maocq.virtualthreads.infrastructure.drivenadapter.database.account;

import com.maocq.virtualthreads.domain.model.account.Account;
import com.maocq.virtualthreads.domain.model.account.gateways.AccountRepository;
import com.maocq.virtualthreads.infrastructure.drivenadapter.database.account.data.AccountData;
import com.maocq.virtualthreads.infrastructure.drivenadapter.database.account.data.AccountDataDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountDataRepository implements AccountRepository {

    private final AccountDataDAO repository;

    @Override
    public Optional<Account> findById(int id) {
        return repository.findById(id)
                .map(this::toEntity);
    }

    @Override
    public Account update(Account account) {
        var data = repository.save(toData(account));
        return toEntity(data);
    }

    private Account toEntity(AccountData data) {
        return new Account(data.getId(), data.getUserId(), data.getAccount(), data.getName(),
                data.getNumber(), data.getBalance(), data.getCurrency(), data.getType(), data.getBank());
    }

    private AccountData toData(Account data) {
        return new AccountData(data.id(), data.userId(), data.account(), data.name(), data.number(), data.balance(),
                data.currency(), data.type(), data.bank());
    }
}
