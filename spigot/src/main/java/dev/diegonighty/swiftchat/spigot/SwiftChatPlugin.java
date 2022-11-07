package dev.diegonighty.swiftchat.spigot;

import dev.diegonighty.swiftchat.core.ChatPlatform;
import dev.diegonighty.swiftchat.core.channel.ExampleDecorator;

public class SwiftChatPlugin {

    public void onUse(ChatPlatform platform) {
        platform.namespace()
                .decorator()
                .use(ExampleDecorator.class, new ExampleDecorator());
    }

}
