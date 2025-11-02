package com.maocq.virtualthreads.domain.usecase;

import com.maocq.virtualthreads.domain.model.account.Account;
import com.maocq.virtualthreads.domain.model.account.gateways.AccountRepository;
import com.maocq.virtualthreads.domain.model.user.User;
import com.maocq.virtualthreads.domain.model.user.gateway.UserGateway;
import com.maocq.virtualthreads.domain.model.primes.Primes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CasesUseCase {

    private final UserGateway userGateway;
    private final AccountRepository accountRepository;

    public String caseOne(int latency) {
        var _ = userGateway.get(latency);
        return Primes.primes(10000);
    }

    public User caseTwo(int latency) {
        return userGateway.get(latency);
    }

    public Optional<Account> caseThree(int id) {
        return accountRepository.findById(id);
    }

    public Account caseFour(int id, int latency) {
        var account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Account not found"));

        var user = userGateway.get(latency);
        var newAccount = account
                .toBuilder()
                .userId(user.id())
                .build();
        return accountRepository.update(newAccount);
    }
}
