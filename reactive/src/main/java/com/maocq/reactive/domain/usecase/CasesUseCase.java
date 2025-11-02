package com.maocq.reactive.domain.usecase;

import com.maocq.reactive.domain.model.account.Account;
import com.maocq.reactive.domain.model.account.gateways.AccountRepository;
import com.maocq.reactive.domain.model.user.User;
import com.maocq.reactive.domain.model.user.gateway.UserGateway;
import com.maocq.reactive.domain.model.primes.Primes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CasesUseCase {

    private final UserGateway userGateway;
    private final AccountRepository accountRepository;

    public Mono<String> caseOne(int latency) {
        return userGateway.get(latency)
                .flatMap(_ -> Mono.just(Primes.primes(10_000)));
    }

    public Mono<User> caseTwo(int latency) {
        return userGateway.get(latency);
    }

    public Mono<Account> caseThree(int id) {
        return accountRepository.findById(id);
    }

    public Mono<Account> caseFour(int id, int latency) {
        return accountRepository.findById(id)
                .flatMap(account -> userGateway.get(latency)
                        .flatMap(user -> {
                            var newAccount = account
                                    .toBuilder()
                                    .userId(user.id())
                                    .build();
                            return accountRepository.update(newAccount);
                        }));
    }
}
