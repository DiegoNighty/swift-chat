package dev.diegonighty.swiftchat.spigot.channel;

import dev.diegonighty.swiftchat.core.channel.ChannelFactory;
import dev.diegonighty.swiftchat.core.channel.ChannelHolder;
import dev.diegonighty.swiftchat.core.channel.ChannelManager;
import dev.diegonighty.swiftchat.core.storage.channel.ChannelRepository;
import dev.diegonighty.swiftchat.core.structure.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public record CachedChannelManager(
        ChannelFactory factory,
        ChannelRepository repository,
        Map<String, Channel> cache
) implements ChannelManager {

    public static ChannelManager create(ChannelFactory factory, ChannelRepository repository) {
        return new CachedChannelManager(factory, repository, new HashMap<>());
    }

    @Override
    public Channel selected(ChannelHolder holder) {
        return cache.get(holder.currentChannel());
    }

    @Override
    public ChannelManager register(Channel channel) {
        cache.put(channel.information().id(), channel);
        return this;
    }

    @Override
    public void modify(String id, Consumer<Channel> action) {
        Channel channel = cache.get(id);

        if (channel != null) {
            action.accept(channel);
        }
    }
}