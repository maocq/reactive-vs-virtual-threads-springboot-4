package com.maocq.reactive.domain.model.hello.gateway;

import reactor.core.publisher.Mono;

public interface HelloGateway {
    Mono<String> hello(int latency);
}