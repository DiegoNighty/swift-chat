package dev.diegonighty.swiftchat.core.structure.message;

import dev.diegonighty.swiftchat.core.common.Metadata;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;

public interface MessageContext {

    ChannelInformation channel();

    Message message();

    MessageContext copy();

    Metadata metadata();

}
