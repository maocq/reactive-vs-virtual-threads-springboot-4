package com.maocq.virtualthreads.infrastructure.drivenadapter.database.account.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AccountDataDAO extends CrudRepository<AccountData, Integer>, QueryByExampleExecutor<AccountData> {
}
