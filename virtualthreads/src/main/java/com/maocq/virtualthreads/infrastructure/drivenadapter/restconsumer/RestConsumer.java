package com.maocq.virtualthreads.infrastructure.drivenadapter.restconsumer;

import com.maocq.virtualthreads.domain.model.hello.gateway.HelloGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class RestConsumer implements HelloGateway {

    private final RestClient restClient;

    @Override
    public String hello(int latency) {
        return restClient
                .get()
                .uri("/{latency}", latency)
                .retrieve()
                .body(String.class);
    }
}