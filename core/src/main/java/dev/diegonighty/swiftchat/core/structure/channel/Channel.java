package dev.diegonighty.swiftchat.core.structure.channel;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public interface Channel {

    ChannelInformation information();

    ChannelMetadata metadata();

    void postMessage(MessageContext ctx);

}
