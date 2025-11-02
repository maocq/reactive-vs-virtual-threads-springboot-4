package com.maocq.reactive.infrastructure.drivenadapter.database.account.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AccountDataDAO extends ReactiveCrudRepository<AccountData, Integer> {
}