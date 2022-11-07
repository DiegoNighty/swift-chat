package dev.diegonighty.swiftchat.core.structure.decorator;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

public interface ChannelDecorator {

    void decorate(MessageContext context);

    void decorate(MessageContext context, ChannelRecipient recipient);

    boolean canListen(MessageContext context, ChannelRecipient recipient);

}
