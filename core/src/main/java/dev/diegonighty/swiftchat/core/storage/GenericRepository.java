package dev.diegonighty.swiftchat.core.storage;

import java.util.function.Consumer;

public interface GenericRepository<K, V extends GenericStorable<K>> {

    V find(K key);

    void save(V value);

    void delete(K key);

    void modify(K key, Consumer<V> action);

}
