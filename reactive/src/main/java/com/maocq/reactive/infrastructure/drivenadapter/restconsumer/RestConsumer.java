package com.maocq.reactive.infrastructure.drivenadapter.restconsumer;

import com.maocq.reactive.domain.model.user.User;
import com.maocq.reactive.domain.model.user.gateway.UserGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestConsumer implements UserGateway {

    public RestConsumer(WebClient client) {
        this.client = client;
    }

    private final WebClient client;

    public Mono<User> get(int latency) {
        return client
                .get()
                .uri("/{latency}", latency)
                .retrieve()
                .bodyToMono(User.class);
    }
}