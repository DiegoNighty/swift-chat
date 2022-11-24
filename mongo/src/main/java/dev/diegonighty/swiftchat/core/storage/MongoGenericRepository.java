package dev.diegonighty.swiftchat.core.storage;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import dev.diegonighty.swiftchat.core.storage.serializer.GenericSerializer;
import org.bson.Document;

import java.util.function.Consumer;

public class MongoGenericRepository<K, V extends GenericStorable<K>> implements GenericRepository<K, V> {

    protected final static ReplaceOptions REPLACE_OPTIONS = new ReplaceOptions()
            .upsert(true);

    protected final GenericSerializer<V, Document> serializer;
    protected final MongoCollection<Document> collection;

    public MongoGenericRepository(
            GenericSerializer<V, Document> serializer,
            MongoCollection<Document> collection
    ) {
        this.serializer = serializer;
        this.collection = collection;
    }

    @Override
    public V find(K key) {
        return findByFieldValue("_id", key);
    }

    @Override
    public void save(V value) {
        collection.replaceOne(
                Filters.eq("_id", value.id()),
                serializer.write(value),
                REPLACE_OPTIONS
        );
    }

    @Override
    public void delete(K key) {
        collection.deleteOne(Filters.eq("_id", key));
    }

    public V findByFieldValue(String key, Object value) {
        var document = collection
                .find(Filters.eq(key, value))
                .first();

        if (document == null || document.isEmpty()) {
            return null;
        }

        return serializer.read(document);
    }

    @Override
    public void modify(K key, Consumer<V> action) {
        var value = find(key);

        if (value == null) {
            return;
        }

        action.accept(value);
        save(value);
    }
}
