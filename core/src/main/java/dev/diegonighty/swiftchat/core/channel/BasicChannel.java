package dev.diegonighty.swiftchat.core.channel;

import dev.diegonighty.swiftchat.core.structure.channel.Channel;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelMetadata;
import dev.diegonighty.swiftchat.core.structure.decorator.sequence.DecoratorChainSequence;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.factory.DecoratorChainFactory;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

public record BasicChannel(
        ChannelInformation information,
        ChannelMetadata metadata,
        DecoratorChainFactory chainFactory,
        DecoratorChainSequence sequence
) implements Channel {

    // Decorator Flow: create a chain with namespaced decorators -> decorate message with global chain
    // iterate audience -> filter recipients with permit decorators -> decorate message with personal chain -> send message

    @Override
    public void postMessage(MessageContext ctx) {
        var decoratorChain = chainFactory.createChain(this);

        for (var decorator : decoratorChain.globals(sequence)) {
            decorator.decorate(ctx);
        }

        var audience = information.audience();
        for (var recipient : audience.recipients()) {
            var permitted = true;

            for (var decoratedPermitted : decoratorChain.permits(sequence)) {
                if (!decoratedPermitted.permit(ctx, recipient)) {
                    permitted = false;
                    break;
                }
            }

            if (!permitted) {
                continue;
            }

            MessageContext copiedContext = ctx.copy();

            for (var decorator : decoratorChain.personals(sequence)) {
                decorator.decorate(copiedContext, recipient);
            }

            recipient.receive(copiedContext);
        }
    }

}
