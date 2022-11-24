package dev.diegonighty.swiftchat.spigot.listener;

import dev.diegonighty.swiftchat.core.SwiftChatPlatformAccessor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        var platform = SwiftChatPlatformAccessor.access();
    }

}
