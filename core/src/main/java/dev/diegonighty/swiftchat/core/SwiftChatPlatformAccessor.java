package dev.diegonighty.swiftchat.core;

import dev.diegonighty.swiftchat.core.error.Errors;

public class SwiftChatPlatformAccessor {

    private static ChatPlatform platform;

    /**
     * Get access to the current ChatPlatform implementation
     * the method throws an IllegalStateException if is not a Platform with granted access yet
     * @return ChatPlatform implementation
     */
    public static synchronized ChatPlatform access() {
        Errors.expectsNonNull(
                platform,
                new IllegalStateException("The platform is not initialized yet")
        );

        return platform;
    }

    /**
     * Grant access to the ChatPlatform singleton
     * only the platform will be placed if is not already granted access
     * @param accessPlatform ChatPlatform implementation
     */
    public static synchronized void grantAccess(ChatPlatform accessPlatform) {
        if (platform == null) {
            platform = accessPlatform;
        }
    }

}
