package com.maocq.reactive.infrastructure.drivenadapter.restconsumer;

import com.maocq.reactive.domain.model.hello.gateway.HelloGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestConsumer implements HelloGateway {

    public RestConsumer(WebClient client) {
        this.client = client;
    }

    private final WebClient client;

    public Mono<String> hello(int latency) {
        return client
                .get()
                .uri("/{latency}", latency)
                .retrieve()
                .bodyToMono(String.class);
    }
}