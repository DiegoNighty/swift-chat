package com.github.diegonighty.swiftchat.api.decorator.type;

import com.github.diegonighty.swiftchat.api.message.MessageContext;

public interface GlobalDecorator extends Decorator {
    void decorate(MessageContext ctx);
}
