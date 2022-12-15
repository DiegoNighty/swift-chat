package dev.diegonighty.swiftchat.spigot.configuration;

import dev.diegonighty.swiftchat.core.configuration.Configuration;
import dev.diegonighty.swiftchat.core.configuration.ConfigurationFactory;
import org.bukkit.plugin.Plugin;

public class SpigotConfigurationFactory implements ConfigurationFactory {

    private final Plugin plugin;

    public SpigotConfigurationFactory(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Configuration createConfiguration(String name) {
        return new SpigotConfiguration(plugin, name);
    }
}
