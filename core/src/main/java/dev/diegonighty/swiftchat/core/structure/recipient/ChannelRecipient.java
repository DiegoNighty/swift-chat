package dev.diegonighty.swiftchat.core.structure.recipient;

import dev.diegonighty.swiftchat.core.storage.GenericStorable;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public interface ChannelRecipient extends GenericStorable<String> {

    default String name() {
        return id();
    }

    void receive(MessageContext ctx);

}
