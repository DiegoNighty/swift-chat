package com.github.diegonighty.swiftchat.core.audience;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import com.github.diegonighty.swiftchat.api.channel.Channel;
import com.github.diegonighty.swiftchat.api.server.ServerInfo;
import net.kyori.adventure.audience.Audience;

import java.util.UUID;

public class ChannelRecipientImpl implements ChannelRecipient {

    private final UUID id;
    private final String username;
    private final ServerInfo serverInfo;

    private final AudienceConverter converter;
    private String selectedChannel;

    public ChannelRecipientImpl(
            UUID id, String username,
            String selectedChannel, ServerInfo serverInfo,
            AudienceConverter converter
    ) {
        this.id = id;
        this.username = username;
        this.serverInfo = serverInfo;
        this.selectedChannel = selectedChannel;
        this.converter = converter;
    }

    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String username() {
        return username;
    }

    @Override
    public String selectedChannel() {
        return selectedChannel;
    }

    @Override
    public void selectChannel(Channel channel) {
        this.selectedChannel = channel.spec().id();
    }

    @Override
    public ServerInfo currentServer() {
        return serverInfo;
    }

    @Override
    public Audience asAudience() {
        return converter.convert(this);
    }
}
