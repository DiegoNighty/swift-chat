package dev.diegonighty.swiftchat.core.storage;

import dev.diegonighty.swiftchat.core.storage.channel.ChannelRepository;

public interface StorageProvider {

    ChannelRepository createChannelRepository();

}
