package dev.diegonighty.swiftchat.core;

import dev.diegonighty.swiftchat.core.container.ChannelContainer;
import dev.diegonighty.swiftchat.core.error.platform.PlatformAlreadyEnabledError;
import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceAdapter;
import dev.diegonighty.swiftchat.core.structure.decorator.namespace.DecoratorNamespace;

public interface ChatPlatform {

    void enable() throws PlatformAlreadyEnabledError;

    Namespaces namespace();

    Containers container();

    Adapters adapter();

    record Adapters(
       RecipientAdapter recipient,
       AudienceAdapter audience
    ) {}

    record Namespaces(
            DecoratorNamespace decorator
    ) {}

    record Containers(
            ChannelContainer channel
    ) {}

}
