package dev.diegonighty.swiftchat.core;

import dev.diegonighty.swiftchat.core.error.platform.PlatformAlreadyEnabledError;
import dev.diegonighty.swiftchat.core.structure.decorator.namespace.DecoratorNamespace;

public interface ChatPlatform {

    void enable() throws PlatformAlreadyEnabledError;

    Namespaces namespace();

    record Namespaces(
            DecoratorNamespace decorator
    ) {}

}
