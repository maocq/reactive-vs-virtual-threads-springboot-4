package com.maocq.virtualthreads.domain.model.user;

import lombok.Builder;

@Builder(toBuilder = true)
public record User(String id, String name) {
}
