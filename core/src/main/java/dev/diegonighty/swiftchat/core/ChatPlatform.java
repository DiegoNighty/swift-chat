package dev.diegonighty.swiftchat.core;

import dev.diegonighty.swiftchat.core.container.ChannelContainer;
import dev.diegonighty.swiftchat.core.error.platform.PlatformAlreadyEnabledError;
import dev.diegonighty.swiftchat.core.structure.decorator.namespace.DecoratorNamespace;

public interface ChatPlatform {

    void enable() throws PlatformAlreadyEnabledError;

    Namespaces namespace();

    Container container();

    record Namespaces(
            DecoratorNamespace decorator
    ) {}

    record Container(
            ChannelContainer channel
    ) {}

}
