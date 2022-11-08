package dev.diegonighty.swiftchat.core.structure.message;

import dev.diegonighty.swiftchat.core.common.Metadata;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelMetadata;

public interface MessageContext {

    ChannelInformation channel();

    ChannelMetadata channelMetadata();

    Message message();

    MessageContext copy();

    Metadata metadata();

}
