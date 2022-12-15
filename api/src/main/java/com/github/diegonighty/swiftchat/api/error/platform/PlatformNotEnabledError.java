package com.github.diegonighty.swiftchat.api.error.platform;

public class PlatformNotEnabledError extends RuntimeException {

    public PlatformNotEnabledError() {
        super("The platform is not enabled yet");
    }

}
