package com.github.diegonighty.swiftchat.core.decorator;

import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.decorator.ChannelDecorator;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorConverter;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorNamespace;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;

import java.util.List;

public record NamespacedDecoratorConverter(
        DecoratorNamespace namespace
) implements DecoratorConverter {

    @Override
    public ChannelDecoratorChain buildChain(ChannelSpec channel) {
        List<ChannelDecorator> decorators = namespace.using(channel.decoratorKeys());

        ChannelDecoratorChain chain = new ChannelDecoratorChainImpl();

        for (var decorator : decorators) {
            chain = decorator.decorate(chain);
        }

        return chain;
    }

}
