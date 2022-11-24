package dev.diegonighty.swiftchat.core.storage.serializer;

import dev.diegonighty.swiftchat.core.storage.GenericStorable;
import org.bson.Document;

public record DocumentWriter(Document document) implements GenericWriter<Document, DocumentWriter> {

    public static DocumentWriter empty() {
        return new DocumentWriter(new Document());
    }

    public static DocumentWriter create(GenericStorable<?> storable) {
        return new DocumentWriter(new Document())
                .write("_id", storable.id());
    }

    @Override
    public DocumentWriter write(String key, Object value) {
        document.append(key, value);
        return this;
    }

    @Override
    public Document build() {
        return document;
    }
}
