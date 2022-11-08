package dev.diegonighty.swiftchat.spigot.message;

import dev.diegonighty.swiftchat.core.structure.message.MessageContext;
import dev.diegonighty.swiftchat.core.structure.message.MessageRender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class FlatMessageRenderer implements MessageRender {

    @Override
    public void render(MessageContext ctx) {
        Player player = Bukkit.getPlayer(UUID.fromString(ctx.message().sender().id()));
        if (player == null) return;

        player.sendMessage(ctx.message().content().toString());
    }
}
