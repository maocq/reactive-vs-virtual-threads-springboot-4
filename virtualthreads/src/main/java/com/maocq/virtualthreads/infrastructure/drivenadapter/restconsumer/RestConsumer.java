package com.maocq.virtualthreads.infrastructure.drivenadapter.restconsumer;

import com.maocq.virtualthreads.domain.model.user.User;
import com.maocq.virtualthreads.domain.model.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class RestConsumer implements UserGateway {

    private final RestClient restClient;

    @Override
    public User get(int latency) {
        return restClient
                .get()
                .uri("/{latency}", latency)
                .retrieve()
                .body(User.class);
    }
}