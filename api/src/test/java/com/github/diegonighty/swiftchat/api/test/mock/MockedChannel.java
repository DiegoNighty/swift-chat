package com.github.diegonighty.swiftchat.api.test.mock;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import com.github.diegonighty.swiftchat.api.channel.Channel;
import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;
import com.github.diegonighty.swiftchat.api.decorator.chain.DecoratorChainSequence;
import com.github.diegonighty.swiftchat.api.message.MessageContext;
import com.github.diegonighty.swiftchat.api.server.ServerInfo;
import com.github.diegonighty.swiftchat.api.structure.Metadata;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.NotNull;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.UUID;

public record MockedChannel(ChannelSpec spec, DecoratorChainSequence sequence) implements Channel {

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
        return Key.key("swiftchat", "mocked");
    }

    public record MockedChannelSpec(Metadata metadata, ChannelDecoratorChain decorators) implements ChannelSpec {

        @Override
        public String id() {
            return "mocked";
        }

        @Override
        public Component name() {
            return Component.text("Mocked");
        }

        @Override
        public List<ChannelRecipient> audience() {
            return List.of(new MockedRecipient());
        }
    }

    public static class MockedRecipient implements ChannelRecipient {

        private Key selectedChannel;

        @Override
        public UUID id() {
            return UUID.randomUUID();
        }

        @Override
        public String username() {
            return "Mocked-Recipient";
        }

        @Override
        public Key selectedChannel() {
            return selectedChannel;
        }

        @Override
        public void selectChannel(Channel channel) {
            this.selectedChannel = channel.key();
        }

        @Override
        public void sendMessage(@NotNull Component message) {
            LoggerFactory.getLogger(MockedRecipient.class)
                    .info(() -> "Message sent to " + username() + ": " + PlainTextComponentSerializer.plainText().serialize(message));
        }

        @Override
        public ServerInfo currentServer() {
            return new ServerInfo() {
                @Override
                public String name() {
                    return "Mocked-Server";
                }

                @Override
                public UUID id() {
                    return UUID.randomUUID();
                }

                @Override
                public boolean isConnected(ChannelRecipient recipient) {
                    return true;
                }

                @Override
                public @NotNull Key key() {
                    return Key.key("mocked", "server");
                }
            };
        }
    }
}
