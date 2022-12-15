package com.github.diegonighty.swiftchat.api.decorator.type;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import com.github.diegonighty.swiftchat.api.message.MessageContext;

public interface PersonalDecorator extends Decorator {
    void decorate(MessageContext context, ChannelRecipient recipient);
}
