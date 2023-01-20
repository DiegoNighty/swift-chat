package com.github.diegonighty.swiftchat.api.message;

import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.metadata.Metadata;
import net.kyori.adventure.text.Component;

public interface MessageContext {

    ChannelSpec channel();

    Message message();

    Metadata metadata();

    MessageContext copy();

    interface Message {

        Component content();

        Component originalContent();

        void edit(ComponentEditor component);

        @FunctionalInterface
        interface ComponentEditor {
            Component edit(Component component);
        }

    }

}
