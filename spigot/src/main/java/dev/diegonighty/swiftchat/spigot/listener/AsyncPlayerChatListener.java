package dev.diegonighty.swiftchat.spigot.listener;

import dev.diegonighty.swiftchat.core.ChatPlatform;
import dev.diegonighty.swiftchat.core.SwiftChatPlatformAccessor;
import dev.diegonighty.swiftchat.core.structure.channel.Channel;
import dev.diegonighty.swiftchat.spigot.StructureAdapter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        ChatPlatform platform = SwiftChatPlatformAccessor.access();

        Channel channel = platform.container()
                .channel()
                .getChannel(event.getPlayer());

        channel.postMessage(StructureAdapter.adapt(event));
    }

}
