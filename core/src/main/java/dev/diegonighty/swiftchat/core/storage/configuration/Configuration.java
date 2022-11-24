package dev.diegonighty.swiftchat.core.storage.configuration;

public interface Configuration {

    String getString(String key);

    int getInt(String key);

    boolean getBoolean(String key);

    double getDouble(String key);

    long getLong(String key);

}
