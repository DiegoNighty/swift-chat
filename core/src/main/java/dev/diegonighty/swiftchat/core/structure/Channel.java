package dev.diegonighty.swiftchat.core.structure;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public interface Channel {

    void postMessage(MessageContext ctx);

}
