package com.maocq.reactive.infrastructure.entrypoints.reactiveweb;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class Handler {

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Hello world!");
    }

    public Mono<ServerResponse> caseOne(ServerRequest serverRequest) {
        var latency = serverRequest.queryParam("latency").map(Integer::valueOf).orElse(0);

        return ServerResponse.ok().bodyValue("Hello world!");
    }

    public Mono<ServerResponse> caseTwo(ServerRequest serverRequest) {
        var latency = serverRequest.queryParam("latency").map(Integer::valueOf).orElse(0);

        return ServerResponse.ok().bodyValue("Hello world!");
    }
}
