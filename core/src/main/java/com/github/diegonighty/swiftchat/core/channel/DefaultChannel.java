package com.github.diegonighty.swiftchat.core.channel;

import com.github.diegonighty.swiftchat.api.channel.Channel;
import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorConverter;
import com.github.diegonighty.swiftchat.api.decorator.chain.DecoratorChainProvider;
import com.github.diegonighty.swiftchat.api.decorator.chain.DecoratorChainSequence;
import com.github.diegonighty.swiftchat.api.message.MessageContext;

public record DefaultChannel(
    ChannelSpec spec,
    DecoratorChainSequence sequence,
    DecoratorConverter converter
) implements Channel {

    @Override
    public void postMessage(MessageContext context) {
        DecoratorChainProvider chain = spec.chain(converter);

        for (var decorator : chain.globals(sequence)) {
            decorator.decorate(context);
        }

        for (var recipient : spec.audience()) {
            var permitted = true;

            for (var decoratedPermitted : chain.permits(sequence)) {
                if (!decoratedPermitted.permit(context, recipient).result()) {
                    permitted = false;
                    break;
                }
            }

            if (!permitted) {
                continue;
            }

            if (chain.personals().isEmpty()) {
                recipient.asAudience().sendMessage(context.message().content());
                continue;
            }

            MessageContext copiedContext = context.copy();

            for (var decorator : chain.personals(sequence)) {
                decorator.decorate(copiedContext, recipient);
            }

            recipient.asAudience().sendMessage(copiedContext.message().content());
        }
    }

}
