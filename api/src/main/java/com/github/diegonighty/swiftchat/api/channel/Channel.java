package com.github.diegonighty.swiftchat.api.channel;

import com.github.diegonighty.swiftchat.api.message.MessageContext;
import net.kyori.adventure.key.Keyed;

public interface Channel extends Keyed {

    /**
     * Gets the channel specifications
     * @return the channel specifications
     */
    ChannelSpec spec();

    /**
     * Processes the message and sends it to the channel.
     * @param context the message context
     */
    void postMessage(MessageContext context);

}
