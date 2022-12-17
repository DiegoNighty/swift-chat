package com.github.diegonighty.swiftchat.api.message;

import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.structure.Metadata;
import net.kyori.adventure.text.Component;

public interface MessageContext {

    ChannelSpec channel();

    Component editableMessage();

    void editMessage(EditableComponent component);

    Component originalMessage();

    Metadata metadata();

    MessageContext copy();

    @FunctionalInterface
    interface EditableComponent {
        Component edit(Component component);
    }

}
