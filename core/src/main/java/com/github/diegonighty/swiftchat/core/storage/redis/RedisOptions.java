package com.github.diegonighty.swiftchat.core.storage.redis;

import com.google.gson.Gson;

import java.time.Duration;

public record RedisOptions(
        String table,
        long expiration,
        Gson gson
) {

    public static RedisOptions with(String table, Gson gson, Duration expiration) {
        return new RedisOptions(table, expiration.toSeconds(), gson);
    }

    public static RedisOptions with(String table, Gson gson) {
        return new RedisOptions(table, -1, gson);
    }

}
