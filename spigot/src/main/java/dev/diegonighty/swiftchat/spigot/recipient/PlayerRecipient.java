package dev.diegonighty.swiftchat.spigot.recipient;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;
import dev.diegonighty.swiftchat.core.structure.message.MessageRenderer;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;
import org.bukkit.entity.Player;

public class PlayerRecipient implements ChannelRecipient {

    private final MessageRenderer renderer;

    private final String name;
    private final String id;

    public PlayerRecipient(Player player, MessageRenderer renderer) {
        this.renderer = renderer;
        this.name = player.getName();
        this.id = player.getUniqueId().toString();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public void receive(MessageContext ctx) {
        renderer.render(this, ctx);
    }
}
