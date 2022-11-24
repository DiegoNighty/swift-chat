package dev.diegonighty.swiftchat.spigot;

import dev.diegonighty.swiftchat.core.SwiftChatPlatformAccessor;
import dev.diegonighty.swiftchat.core.structure.channel.Channel;
import dev.diegonighty.swiftchat.core.structure.message.Message;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;
import dev.diegonighty.swiftchat.spigot.message.SimpleMessageContext;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class StructureAdapter {

    public static Player adapt(ChannelRecipient recipient) {
        return Bukkit.getPlayer(UUID.fromString(recipient.id()));
    }

    public static MessageContext adapt(AsyncPlayerChatEvent event, Channel channel) {
        var platform = SwiftChatPlatformAccessor.access();

        return new SimpleMessageContext(
                channel,
                new Message(
                        event.getMessage(),
                        event.getFormat(),
                        platform.recipientAdapter()
                                .adapt(event.getPlayer())
                )
        );
    }

}
