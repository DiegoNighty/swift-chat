package dev.diegonighty.swiftchat.core.channel;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain;

public class ExampleDecorator implements ChannelDecorator {

    @Override
    public ChannelDecoratorChain decorate(ChannelDecoratorChain chain) {
        return chain
                .permit((ctx, recipient) -> !recipient.equals(ctx.sender()))
                .decorate(ctx -> ctx.formatMessage("a"))
                .decorate((ctx, recipient) -> ctx.formatMessage(recipient.toString()));
    }
}
