package dev.diegonighty.swiftchat.spigot.message;

import dev.diegonighty.swiftchat.core.structure.message.Message;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;
import dev.diegonighty.swiftchat.core.structure.message.MessageRenderer;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;
import dev.diegonighty.swiftchat.spigot.StructureAdapter;
import org.bukkit.entity.Player;

public class FlatMessageRenderer implements MessageRenderer {

    @Override
    public void render(ChannelRecipient listener, MessageContext ctx) {
        Player listenerPlayer = StructureAdapter.adapt(listener);
        Message message = ctx.message();

        listenerPlayer.sendMessage(
                message.format()
                        .append(message.content())
                        .toString()
        );
    }
}
