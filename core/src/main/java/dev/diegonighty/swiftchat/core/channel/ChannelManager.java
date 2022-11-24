package dev.diegonighty.swiftchat.core.channel;

import dev.diegonighty.swiftchat.core.storage.channel.ChannelRepository;
import dev.diegonighty.swiftchat.core.structure.channel.Channel;

import java.util.function.Consumer;

public interface ChannelManager {

    ChannelFactory factory();

    ChannelRepository repository();

    /**
     * Selected channel from cache
     * @param holder channel holder
     * @return channel or null if not found
     */
    Channel selected(ChannelHolder holder);

    /**
     * Register channel to cache
     * @param channel channel
     * @return the same channel manager instance
     */
    ChannelManager register(Channel channel);

    void modify(String id, Consumer<Channel> action);

}
