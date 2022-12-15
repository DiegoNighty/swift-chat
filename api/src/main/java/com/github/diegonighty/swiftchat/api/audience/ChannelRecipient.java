package com.github.diegonighty.swiftchat.api.audience;

import com.github.diegonighty.swiftchat.api.channel.Channel;
import com.github.diegonighty.swiftchat.api.server.ServerInfo;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;

import java.util.UUID;

public interface ChannelRecipient extends Audience {

    /**
     * Returns the unique identifier of this recipient.
     * @return the unique identifier of this recipient.
     */
    UUID id();

    /**
     * Returns the name of this recipient.
     * @return the name of this recipient.
     */
    String username();

    /**
     * Returns the key of the selected channel
     * @return the key of the selected channel
     */
    Key selectedChannel();

    /**
     * Selects the channel
     * @param channel the channel to select
     */
    void selectChannel(Channel channel);

    /**
     * Returns the server this recipient is connected to.
     * @return the server this recipient is connected to.
     */
    ServerInfo currentServer();

}
