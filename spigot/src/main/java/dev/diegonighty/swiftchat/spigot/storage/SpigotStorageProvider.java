package dev.diegonighty.swiftchat.spigot.storage;

import dev.diegonighty.swiftchat.core.storage.StorageProvider;
import dev.diegonighty.swiftchat.core.storage.channel.ChannelRepository;
import dev.diegonighty.swiftchat.core.storage.configuration.Configuration;
import dev.diegonighty.swiftchat.core.storage.configuration.ConfigurationFactory;

public class SpigotStorageProvider implements StorageProvider {

    private final Configuration configuration;

    public SpigotStorageProvider(ConfigurationFactory configuration) {
        this.configuration = configuration.createConfiguration("storage");
    }

    @Override
    public ChannelRepository createChannelRepository() {
        //TODO implement

        return null;
    }
}
