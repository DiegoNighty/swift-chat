package dev.diegonighty.swiftchat.core.structure.message;

import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

public interface MessageRenderer {

    void render(ChannelRecipient listener, MessageContext ctx);

}
