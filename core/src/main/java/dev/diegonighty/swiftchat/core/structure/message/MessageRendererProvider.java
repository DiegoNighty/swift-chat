package dev.diegonighty.swiftchat.core.structure.message;

public class MessageRendererProvider {

    private MessageRenderer renderer;

    public void setRenderer(MessageRenderer renderer) {
        this.renderer = renderer;
    }

    public MessageRenderer renderer() {
        return renderer;
    }

}
