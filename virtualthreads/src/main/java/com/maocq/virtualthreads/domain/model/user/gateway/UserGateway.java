package com.maocq.virtualthreads.domain.model.user.gateway;

import com.maocq.virtualthreads.domain.model.user.User;

public interface UserGateway {

    User get(int latency);
}