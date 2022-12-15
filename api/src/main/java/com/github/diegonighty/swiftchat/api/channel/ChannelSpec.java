package com.github.diegonighty.swiftchat.api.channel;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;
import com.github.diegonighty.swiftchat.api.structure.Metadata;
import net.kyori.adventure.text.Component;

import java.util.List;

public interface ChannelSpec {

    /**
     * The id of the channel.
     * @return the id of the channel.
     */
    String id();

    /**
     * The name of the channel.
     * @return the name of the channel.
     */
    Component name();

    /**
     * The metadata of the channel.
     * @return the metadata of the channel.
     */
    Metadata metadata();

    /**
     * The decorator chain of the channel.
     * @return the decorator chain of the channel.
     */
    List<ChannelRecipient> audience();

    /**
     * The decorator chain of the channel.
     * @return the decorator chain of the channel.
     */
    ChannelDecoratorChain decorators();

}
