package com.github.diegonighty.swiftchat.core.message;

import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.message.MessageContext;
import com.github.diegonighty.swiftchat.api.structure.Metadata;
import net.kyori.adventure.text.Component;

public class SimpleMessageContext implements MessageContext {

    private final ChannelSpec channel;
    private final Metadata metadata;

    private final Component originalMessage;
    private Component editableMessage;

    private SimpleMessageContext(
            ChannelSpec channel,
            Component originalMessage,
            Component editableMessage,
            Metadata metadata
    ) {
        this.channel = channel;
        this.originalMessage = originalMessage;
        this.editableMessage = editableMessage;
        this.metadata = metadata;
    }

    public SimpleMessageContext(ChannelSpec channel, Component originalMessage, Metadata metadata) {
        this(channel, originalMessage, originalMessage, metadata);
    }

    @Override
    public ChannelSpec channel() {
        return channel;
    }

    @Override
    public Component editableMessage() {
        return editableMessage;
    }

    @Override
    public void editMessage(EditableComponent component) {
        this.editableMessage = component.edit(editableMessage);
    }

    @Override
    public Component originalMessage() {
        return originalMessage;
    }

    @Override
    public Metadata metadata() {
        return metadata;
    }

    @Override
    public MessageContext copy() {
        return new SimpleMessageContext(
                channel,
                originalMessage,
                editableMessage,
                metadata
        );
    }
}