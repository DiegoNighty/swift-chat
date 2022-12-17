package com.github.diegonighty.swiftchat.core.storage.memory;

import com.github.diegonighty.swiftchat.core.storage.Storage;

import java.util.Map;

public abstract class MemoryStorage<I, E> implements Storage<I, E> {

    private final Map<I, E> storage;

    protected MemoryStorage(Map<I, E> storage) {
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
        storage.remove(extractId(entity));
    }
}
