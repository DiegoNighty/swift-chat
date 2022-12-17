package com.github.diegonighty.swiftchat.core.storage.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public record RedisManager(
        JedisPool jedisPool, String app
) {

    public void update(
            String table, String key,
            String value, long seconds
    ) {
        try (Jedis jedis = jedisPool.getResource()) {
            String tableName = makeTable(table);
            jedis.hset(tableName, key, value);

            if (seconds > 0) {
                jedis.expire(tableName, seconds);
            }
        }
    }

    public String read(String table, String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.hget(makeTable(table), key);
        }
    }

    public void delete(String table, String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.hdel(makeTable(table), key);
        }
    }

    public String makeTable(String table) {
        return app + ":" + table;
    }

}
