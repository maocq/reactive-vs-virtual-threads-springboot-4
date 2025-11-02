package com.maocq.reactive.infrastructure.drivenadapter.database.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "database")
public record PostgresqlConnectionProperties(
        String database, String schema, String username, String password, String host, Integer port) {
}
