package com.maocq.reactive.domain.usecase;

import com.maocq.reactive.domain.model.hello.gateway.HelloGateway;
import com.maocq.reactive.domain.model.primes.Primes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CasesUseCase {

    private final HelloGateway helloGateway;

    public Mono<String> caseOne(int latency) {
        return helloGateway.hello(latency)
                .flatMap(_ -> Mono.just(Primes.primes(10000)));
    }

    public Mono<String> caseTwo(int latency) {
        return helloGateway.hello(latency);
    }
}
