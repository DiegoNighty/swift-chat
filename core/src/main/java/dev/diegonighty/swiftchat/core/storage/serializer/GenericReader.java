package dev.diegonighty.swiftchat.core.storage.serializer;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

public interface GenericReader<Data> {

    Date readDate(String field);

    String readString(String field);

    int readInt(String field);

    long readLong(String field);

    double readDouble(String field);

    boolean readBoolean(String field);

    <T> List<T> readList(String field, Class<T> clazz);

    <T> List<Class<? extends T>> readClazzList(String field, Class<T> clazz);

    <T> T readChild(
            String field,
            Function<GenericReader<Data>, T> parser
    );



}
