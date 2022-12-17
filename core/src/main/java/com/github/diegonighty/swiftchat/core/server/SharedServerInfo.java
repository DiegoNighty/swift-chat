package com.github.diegonighty.swiftchat.core.server;

import com.github.diegonighty.swiftchat.api.ChatPlatform;
import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import com.github.diegonighty.swiftchat.api.server.ServerInfo;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record SharedServerInfo(
        String name,
        UUID id
) implements ServerInfo {

    private final static Key KEY = Key.key(ChatPlatform.NAMESPACE, "server_info");

    @Override
    public boolean isConnected(ChannelRecipient recipient) {
        return id.equals(recipient.currentServer().id());
    }

    @Override
    public @NotNull Key key() {
        return KEY;
    }
}
