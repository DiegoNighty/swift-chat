package dev.diegonighty.swiftchat.core.structure.decorator.chain;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

import java.util.List;

public interface ChannelDecoratorChain {

    List<ChannelDecorator> decorate(MessageContext ctx);

}
