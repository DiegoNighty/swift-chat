package dev.diegonighty.swiftchat.spigot.configuration;

import dev.diegonighty.swiftchat.core.configuration.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SpigotConfiguration extends YamlConfiguration implements Configuration {

    private final Plugin plugin;
    private final String fileName;
    private final File file;

    public SpigotConfiguration(Plugin plugin, File file, String fileName) {
        Objects.requireNonNull(plugin, "Plugin cannot be null");
        Objects.requireNonNull(fileName, "File name cannot be null");
        Objects.requireNonNull(file, "Parent file cannot be null");

        this.plugin = plugin;
        this.fileName = fileName;
        this.file = new File(file, fileName);

        saveDef();
        reloadFile();
    }

    public SpigotConfiguration(Plugin plugin, String fileName) {
        this(plugin, plugin.getDataFolder(), fileName);
    }

    @Override
    public String getString(String path) {
        return formatString(super.getString(path, path));
    }

    @Override
    public <T> T get(String key, Class<T> type) {
        return type.cast(get(key));
    }

    @Override
    public <T> List<T> getList(String key, Class<T> type) {
        return Objects.requireNonNull(getList(key))
                .stream()
                .map(type::cast)
                .toList();
    }

    @Override
    public List<String> getStringList(String path) {
        return super.getStringList(path).stream()
                .map(this::formatString)
                .toList();
    }

    public void reloadFile() {
        try {
            this.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void saveDef() {
        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }
    }

    public void save() {
        try {
            save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatString(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
