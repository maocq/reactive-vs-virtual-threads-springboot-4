package com.maocq.virtualthreads.domain.usecase;

import com.maocq.virtualthreads.domain.model.user.User;
import com.maocq.virtualthreads.domain.model.user.gateway.UserGateway;
import com.maocq.virtualthreads.domain.model.primes.Primes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CasesUseCase {

    private final UserGateway userGateway;

    public String caseOne(int latency) {
        var _ = userGateway.get(latency);
        return Primes.primes(10000);
    }

    public User caseTwo(int latency) {
        return userGateway.get(latency);
    }
}
