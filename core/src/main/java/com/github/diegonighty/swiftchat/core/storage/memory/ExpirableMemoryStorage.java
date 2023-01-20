package com.github.diegonighty.swiftchat.core.storage.memory;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.diegonighty.swiftchat.core.storage.Storage;

public class ExpirableMemoryStorage<I, E> implements Storage<I, E> {

    private final LoadingCache<I, E> storage;
    private final IDExtractor<E, I> extractor;

    public ExpirableMemoryStorage(
            LoadingCache<I, E> storage,
            IDExtractor<E, I> extractor
    ) {
        this.storage = storage;
        this.extractor = extractor;
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
        storage.invalidate(extract().from(entity));
    }

    @Override
    public IDExtractor<E, I> extract() {
        return extractor;
    }
}
