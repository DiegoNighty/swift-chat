package dev.diegonighty.swiftchat.core.storage;

public interface GenericRepository<K, V extends GenericStorable<K>> {

    V find(K key);

    void save(V value);

    void delete(K key);

}
