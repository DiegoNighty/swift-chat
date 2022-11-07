package dev.diegonighty.swiftchat.core.channel;

import dev.diegonighty.swiftchat.core.structure.channel.Channel;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelMetadata;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public record BasicChannel(
        ChannelInformation information,
        ChannelMetadata metadata,
        ChannelDecoratorChain decoratorChain
) implements Channel {

    @Override
    public void postMessage(MessageContext ctx) {
        var audience = information.audience();
        var globalDecorated = false;
    }

}
