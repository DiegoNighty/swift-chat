package com.github.diegonighty.swiftchat.core.message;

import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.message.MessageContext;
import com.github.diegonighty.swiftchat.api.metadata.Metadata;

public record SimpleMessageContext(
        ChannelSpec channel,
        Message message,
        Metadata metadata
) implements MessageContext {

    @Override
    public MessageContext copy() {
        return new SimpleMessageContext(
                channel,
                message,
                metadata
        );
    }
}