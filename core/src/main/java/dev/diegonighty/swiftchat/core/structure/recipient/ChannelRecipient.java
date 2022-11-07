package dev.diegonighty.swiftchat.core.structure.recipient;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public interface ChannelRecipient {

    void receive(MessageContext ctx);

}
