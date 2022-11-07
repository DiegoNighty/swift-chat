package dev.diegonighty.swiftchat.core.structure.decorator.chain;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public interface ChannelDecoratorChain {

    void decorate(MessageContext ctx);

}
