package dev.diegonighty.swiftchat.core.structure.decorator.chain.factory;

import dev.diegonighty.swiftchat.core.structure.channel.Channel;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChainImpl;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.DecoratorChainProvider;
import dev.diegonighty.swiftchat.core.structure.decorator.namespace.DecoratorNamespace;

public class DecoratorChainFactory {

    private final DecoratorNamespace namespace;

    public DecoratorChainFactory(DecoratorNamespace namespace) {
        this.namespace = namespace;
    }

    public DecoratorChainProvider createChain(Channel channel) {
        var decorators = channel.information()
                .decorators()
                .stream()
                .map(namespace::using)
                .toList();

        ChannelDecoratorChain chain = new ChannelDecoratorChainImpl();

        for (var decorator : decorators) {
            chain = decorator.decorate(chain);
        }

        return chain;
    }
}
