package dev.diegonighty.swiftchat.core.structure.message;

import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

public interface MessageContext {

    ChannelInformation channel();

    ChannelRecipient sender();

    void formatMessage(String message);

    MessageContext copy();

}
