package dev.diegonighty.swiftchat.core.structure.decorator;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

public abstract class DefaultChannelDecorator implements ChannelDecorator {

    /*
      All methods are empty by default, so you can override only the ones you need.
     */

    @Override
    public void decorate(MessageContext context) {}

    @Override
    public void decorate(MessageContext context, ChannelRecipient recipient) {}

    @Override
    public boolean canListen(MessageContext context, ChannelRecipient recipient) {
        return true;
    }
}
