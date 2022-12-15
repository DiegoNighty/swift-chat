package com.github.diegonighty.swiftchat.api.structure;

import java.util.HashMap;
import java.util.Map;

public record Metadata(Map<String, Object> map) {

    public static Metadata empty() {
        return new Metadata(new HashMap<>());
    }

    public static Metadata of(Map<String, Object> metadata) {
        return new Metadata(metadata);
    }

    public void set(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public String asString(String key) {
        return (String) map.get(key);
    }

    public int asInt(String key) {
        return (int) map.get(key);
    }

    public double asDouble(String key) {
        return (double) map.get(key);
    }

    public float asFloat(String key) {
        return (float) map.get(key);
    }

    public long asLong(String key) {
        return (long) map.get(key);
    }

    public boolean asBoolean(String key) {
        return (boolean) map.get(key);
    }

    public <T> T as(String key, Class<T> clazz) {
        return clazz.cast(map.get(key));
    }

}
