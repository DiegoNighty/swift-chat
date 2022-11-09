package dev.diegonighty.swiftchat.core.storage.serializer;

import dev.diegonighty.swiftchat.core.storage.GenericStorable;

public interface GenericSerializer<Object extends GenericStorable<?>, Data> {

    Object read(Data data);

    Data write(Object object);

}
