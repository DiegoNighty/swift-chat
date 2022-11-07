package dev.diegonighty.swiftchat.core.structure.decorator;

import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain;

public interface ChannelDecorator {

    ChannelDecoratorChain decorate(ChannelDecoratorChain chain);

}
