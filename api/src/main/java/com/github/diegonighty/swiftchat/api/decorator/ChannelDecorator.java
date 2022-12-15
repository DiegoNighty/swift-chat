package com.github.diegonighty.swiftchat.api.decorator;

import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;

public interface ChannelDecorator {

    ChannelDecoratorChain decorate(ChannelDecoratorChain chain);

}
