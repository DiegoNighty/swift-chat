package com.github.diegonighty.swiftchat.core.message;

import com.github.diegonighty.swiftchat.api.message.MessageContext;
import net.kyori.adventure.text.Component;

public class MessageImpl implements MessageContext.Message {

    private final Component originalContent;
    private Component content;

    public MessageImpl(Component originalContent) {
        this.originalContent = originalContent;
        this.content = originalContent;
    }

    @Override
    public Component content() {
        return content;
    }

    @Override
    public Component originalContent() {
        return originalContent;
    }

    @Override
    public void edit(ComponentEditor component) {
        this.content = component.edit(content);
    }
}
