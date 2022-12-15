package com.github.diegonighty.swiftchat.core.channel;

import com.github.diegonighty.swiftchat.api.ChatPlatform;
import com.github.diegonighty.swiftchat.api.channel.Channel;
import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;
import com.github.diegonighty.swiftchat.api.decorator.chain.DecoratorChainSequence;
import com.github.diegonighty.swiftchat.api.message.MessageContext;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

public record DefaultChannel(
    ChannelSpec spec,
    DecoratorChainSequence sequence
) implements Channel {

    private static final Key KEY = Key.key(ChatPlatform.NAMESPACE, "default");

    @Override
    public void postMessage(MessageContext context) {
        ChannelDecoratorChain chain = spec.decorators();

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

            MessageContext copiedContext = context.copy();

            for (var decorator : chain.personals(sequence)) {
                decorator.decorate(copiedContext, recipient);
            }

            recipient.sendMessage(copiedContext.message());
        }
    }

    @Override
    public @NotNull Key key() {
        return KEY;
    }
}
