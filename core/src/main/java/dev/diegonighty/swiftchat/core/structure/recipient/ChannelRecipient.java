package dev.diegonighty.swiftchat.core.structure.recipient;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public interface ChannelRecipient {

    default String name() {
        return id();
    }

    String id();

    void receive(MessageContext ctx);

}
