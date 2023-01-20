package com.github.diegonighty.swiftchat.core.storage.memory;

import com.github.diegonighty.swiftchat.core.storage.Storage;

import java.util.Map;

public class MemoryStorage<I, E> implements Storage<I, E> {

    private final Map<I, E> storage;
    private final IDExtractor<E, I> extractor;

    protected MemoryStorage(
            Map<I, E> storage,
            IDExtractor<E, I> extractor
    ) {
        this.storage = storage;
        this.extractor = extractor;
    }

    @Override
    public IDExtractor<E, I> extract() {
        return extractor;
    }

    @Override
    public E read(I id) {
        return storage.get(id);
    }

    @Override
    public void update(E entity) {
        storage.put(extract().from(entity), entity);
    }

    @Override
    public void delete(E entity) {
        storage.remove(extract().from(entity));
    }
}
