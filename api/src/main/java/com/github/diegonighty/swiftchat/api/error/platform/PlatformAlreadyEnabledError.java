package com.github.diegonighty.swiftchat.api.error.platform;

public class PlatformAlreadyEnabledError extends RuntimeException {

    public PlatformAlreadyEnabledError() {
        super("The platform is already enabled!");
    }

}
