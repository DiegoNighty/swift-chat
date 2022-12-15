package dev.diegonighty.swiftchat.spigot.message;

import dev.diegonighty.swiftchat.core.message.MessageContext;
import dev.diegonighty.swiftchat.core.message.MessageRenderer;
import dev.diegonighty.swiftchat.core.recipient.ChannelRecipient;
import dev.diegonighty.swiftchat.spigot.StructureAdapter;

public class FlatMessageRenderer implements MessageRenderer {

    @Override
    public void render(ChannelRecipient listener, MessageContext ctx) {
        var listenerPlayer = StructureAdapter.adapt(listener);
        var message = ctx.message();

        listenerPlayer.sendMessage(
                message.format()
                        .append(message.content())
                        .toString()
        );
    }
}
