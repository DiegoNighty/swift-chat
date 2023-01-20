package com.github.diegonighty.swiftchat.core.storage.redis;

import com.github.diegonighty.swiftchat.core.storage.Storage;
import com.google.gson.Gson;

public class RedisStorage<I, E> implements Storage<I, E> {

    private final RedisManager redisManager;

    private final String table;
    private final Gson gson;
    private final long expiration;

    private final Class<? extends E> type;
    private final IDExtractor<E, I> extractor;

    protected RedisStorage(
            RedisManager redisManager,
            RedisOptions options,
            Class<? extends E> type,
            IDExtractor<E, I> extractor
    ) {
        this.redisManager = redisManager;

        this.table = options.table();
        this.gson = options.gson();
        this.expiration = options.expiration();

        this.type = type;
        this.extractor = extractor;
    }

    @Override
    public IDExtractor<E, I> extract() {
        return extractor;
    }

    @Override
    public E read(I id) {
        return gson.fromJson(redisManager.read(table, id.toString()), type);
    }

    @Override
    public void update(E entity) {
        redisManager.update(table, extract().from(entity).toString(), gson.toJson(entity), expiration);
    }

    @Override
    public void delete(E entity) {
        redisManager.delete(table, extract().from(entity).toString());
    }

}
