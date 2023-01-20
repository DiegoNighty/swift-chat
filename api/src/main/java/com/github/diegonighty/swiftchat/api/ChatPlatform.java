package com.github.diegonighty.swiftchat.api;

import com.github.diegonighty.swiftchat.api.decorator.DecoratorNamespace;
import com.github.diegonighty.swiftchat.api.server.ServerInfo;

public interface ChatPlatform {

    String NAMESPACE = "swiftchat";

    /**
     * Gets the server info.
     * @return the server info
     */
    ServerInfo server();

    /**
     * Gets the decorator namespace.
     * @return the decorator namespace
     */
    DecoratorNamespace decoratorNamespace();

}
