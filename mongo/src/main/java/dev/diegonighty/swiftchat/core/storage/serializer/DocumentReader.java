package dev.diegonighty.swiftchat.core.storage.serializer;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class DocumentReader implements GenericReader<Document> {

    private final Document document;

    private DocumentReader(Document document) {
        this.document = document;
    }

    @Override
    public Date readDate(String field) {
        return document.getDate(field);
    }

    @Override
    public String readString(String field) {
        return document.getString(field);
    }

    @Override
    public double readDouble(String field) {
        return document.getDouble(field);
    }

    @Override
    public long readLong(String field) {
        return document.getLong(field);
    }

    @Override
    public int readInt(String field) {
        return document.getInteger(field);
    }

    @Override
    public boolean readBoolean(String field) {
        return document.getBoolean(field);
    }

    @Override
    public <T> List<T> readList(String field, Class<T> clazz) {
        return document.getList(field, clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<Class<? extends T>> readClazzList(String field, Class<T> entity) {
        List<String> query = document.getList(field, String.class);
        List<Class<? extends T>> classes = new ArrayList<>();

        for (String className : query) {
            try {
                Class<?> unknown = Class.forName(className);
                if (entity.isAssignableFrom(unknown)) {
                    classes.add((Class<? extends T>) unknown);
                }
            } catch (ClassNotFoundException e) {
                new Exception("Error while deserializing unknown class by " + className).printStackTrace();
            }
        }

        return classes;
    }

    @Override
    public <T> T readChild(String field, Function<GenericReader<Document>, T> parser) {
        Document child = document.get(field, Document.class);

        if (child == null) {
            return null;
        }

        return parser.apply(DocumentReader.create(child));
    }

    public Document getChild(String field) {
        return document.get(field, Document.class);
    }

    public static DocumentReader create(Document document) {
        return new DocumentReader(document);
    }
}
