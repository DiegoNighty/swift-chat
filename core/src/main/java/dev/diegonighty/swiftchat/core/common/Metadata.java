package dev.diegonighty.swiftchat.core.common;

import java.util.HashMap;
import java.util.Map;

public class Metadata {

    private final Map<String, Object> metadata = new HashMap<>();

    public void set(String key, Object value) {
        metadata.put(key, value);
    }

    public Object get(String key) {
        return metadata.get(key);
    }

    public String asString(String key) {
        return (String) metadata.get(key);
    }

    public int asInt(String key) {
        return (int) metadata.get(key);
    }

    public double asDouble(String key) {
        return (double) metadata.get(key);
    }

    public float asFloat(String key) {
        return (float) metadata.get(key);
    }

    public long asLong(String key) {
        return (long) metadata.get(key);
    }

    public boolean asBoolean(String key) {
        return (boolean) metadata.get(key);
    }

}
