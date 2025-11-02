package com.maocq.virtualthreads.infrastructure.drivenadapter.database.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource")
public record PostgresqlConnectionProperties(
        String url, String username, String password) {
}
