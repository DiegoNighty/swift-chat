package dev.diegonighty.swiftchat.core.error.platform;

public class PlatformAlreadyEnabledError extends RuntimeException {

    public PlatformAlreadyEnabledError() {
        super("The platform is already enabled!");
    }

}
