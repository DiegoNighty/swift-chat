package dev.diegonighty.swiftchat.spigot.storage;

import dev.diegonighty.swiftchat.core.configuration.Configuration;
import dev.diegonighty.swiftchat.core.configuration.ConfigurationFactory;
import dev.diegonighty.swiftchat.core.storage.ChannelRepository;

public class SpigotStorageProvider {

    private final Configuration configuration;

    public SpigotStorageProvider(ConfigurationFactory configuration) {
        this.configuration = configuration.createConfiguration("storage");
    }

    public Repository<?> createChannelRepository() {
        //TODO implement

        return null;
    }
}
