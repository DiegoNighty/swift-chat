package dev.diegonighty.swiftchat.core;

import dev.diegonighty.swiftchat.core.error.platform.PlatformAlreadyEnabledError;

public interface ChatPlatform {

    void enable() throws PlatformAlreadyEnabledError;

}
