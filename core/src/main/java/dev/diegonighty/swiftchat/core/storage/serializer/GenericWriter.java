package dev.diegonighty.swiftchat.core.storage.serializer;

public interface GenericWriter<Data, This extends GenericWriter<Data, ?>> {

    This write(String key, Object value);

    Data build();

}
