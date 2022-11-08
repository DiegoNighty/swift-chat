package dev.diegonighty.swiftchat.spigot;

import dev.diegonighty.swiftchat.core.ChatPlatform;
import dev.diegonighty.swiftchat.spigot.decorator.RadialChannelDecorator;

public class SwiftChatPlugin {

    public void onUse(ChatPlatform platform) {
        platform.namespace()
                .decorator()
                .use(RadialChannelDecorator.class, new RadialChannelDecorator());
    }

}
