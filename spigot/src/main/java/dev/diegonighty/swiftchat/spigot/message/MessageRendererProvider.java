package dev.diegonighty.swiftchat.spigot.message;

import dev.diegonighty.swiftchat.core.structure.message.MessageRenderer;

public class MessageRendererProvider {

    private MessageRenderer renderer;

    public void setRenderer(MessageRenderer renderer) {
        this.renderer = renderer;
    }

    public MessageRenderer renderer() {
        return renderer;
    }

}
