package com.github.diegonighty.swiftchat.core.storage.memory;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.diegonighty.swiftchat.core.storage.Storage;

public abstract class ExpirableMemoryStorage<I, E> implements Storage<I, E> {

    private final LoadingCache<I, E> storage;

    protected ExpirableMemoryStorage(LoadingCache<I, E> storage) {
        this.storage = storage;
    }

    @Override
    public E read(I id) {
        return storage.get(id);
    }

    @Override
    public void update(E entity) {
        storage.put(extractId(entity), entity);
    }

    @Override
    public void delete(E entity) {
        storage.invalidate(extractId(entity));
    }
}
