package dev.diegonighty.swiftchat.core.structure.message;

import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

public class Message {

    private StringBuilder content;
    private StringBuilder format;

    private final ChannelRecipient sender;

    public Message(String content, String format, ChannelRecipient sender) {
        this.content = new StringBuilder(content);
        this.format = new StringBuilder(format);
        this.sender = sender;
    }

    public Message copy() {
        return new Message(content.toString(), format.toString(), sender);
    }

    public StringBuilder content() {
        return content;
    }

    public void setContent(String content) {
        this.content = new StringBuilder(content);
    }

    public ChannelRecipient sender() {
        return sender;
    }

    public StringBuilder format() {
        return format;
    }

    public void setFormat(String format) {
        this.format = new StringBuilder(format);
    }
}
