package com.github.diegonighty.swiftchat.api.decorator;

import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;

public interface DecoratorConverter {

    /**
     * Converts the decorator keys of the channel into a decorator chain.
     * @param channel the channel to convert.
     * @return the decorator chain of the channel.
     */
    ChannelDecoratorChain buildChain(ChannelSpec channel);

}
