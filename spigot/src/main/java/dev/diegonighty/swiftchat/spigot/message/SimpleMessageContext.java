package dev.diegonighty.swiftchat.spigot.message;

import dev.diegonighty.swiftchat.core.common.Metadata;
import dev.diegonighty.swiftchat.core.structure.channel.Channel;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.message.Message;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public class SimpleMessageContext implements MessageContext {

    private final Metadata metadata = Metadata.empty();
    private final Message message;

    private final Channel channel;

    public SimpleMessageContext(Channel channel, Message message) {
        this.message = message;
        this.channel = channel;
    }

    @Override
    public ChannelInformation channel() {
        return channel.information();
    }

    @Override
    public Message message() {
        return message;
    }

    @Override
    public MessageContext copy() {
        return new SimpleMessageContext(channel, message.copy());
    }

    @Override
    public Metadata metadata() {
        return metadata;
    }

}
