package com.github.diegonighty.swiftchat.api.server;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import net.kyori.adventure.key.Keyed;

import java.util.UUID;

public interface ServerInfo extends Keyed {

    String name();

    UUID id();

    boolean isConnected(ChannelRecipient recipient);

}
