package com.github.diegonighty.swiftchat.core.storage.redis;

import com.github.diegonighty.swiftchat.core.storage.Storage;
import com.google.gson.Gson;

public abstract class RedisStorage<I, E> implements Storage<I, E> {

    private final RedisManager redisManager;

    private final String table;
    private final Gson gson;
    private final long expiration;

    private final Class<? extends E> type;

    protected RedisStorage(
            RedisManager redisManager,
            RedisOptions options,
            Class<? extends E> type
    ) {
        this.redisManager = redisManager;

        this.table = options.table();
        this.gson = options.gson();
        this.expiration = options.expiration();

        this.type = type;
    }

    @Override
    public E read(I id) {
        return gson.fromJson(redisManager.read(table, id.toString()), type);
    }

    @Override
    public void update(E entity) {
        redisManager.update(table, extractId(entity).toString(), gson.toJson(entity), expiration);
    }

    @Override
    public void delete(E entity) {
        redisManager.delete(table, extractId(entity).toString());
    }

}
