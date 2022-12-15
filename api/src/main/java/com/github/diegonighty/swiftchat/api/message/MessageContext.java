package com.github.diegonighty.swiftchat.api.message;

import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.structure.Metadata;
import net.kyori.adventure.text.Component;

public interface MessageContext {

    ChannelSpec channel();

    Component message();

    void modifyMessage(Component message);

    Component originalMessage();

    Metadata metadata();

    MessageContext copy();

}
