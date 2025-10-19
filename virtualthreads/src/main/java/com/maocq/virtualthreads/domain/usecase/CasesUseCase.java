package com.maocq.virtualthreads.domain.usecase;

import com.maocq.virtualthreads.domain.model.hello.gateway.HelloGateway;
import com.maocq.virtualthreads.domain.model.primes.Primes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CasesUseCase {

    private final HelloGateway helloGateway;

    public String caseOne(int latency) {
        var _ = helloGateway.hello(latency);
        return Primes.primes(10000);
    }

    public String caseTwo(int latency) {
        return helloGateway.hello(latency);
    }
}
