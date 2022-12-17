package com.github.diegonighty.swiftchat.core.decorator;

import com.github.diegonighty.swiftchat.api.decorator.ChannelDecorator;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorNamespace;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CachedDecoratorNamespace implements DecoratorNamespace {

    private final static String CHANNEL_NAMESPACE = "channel";
    private final Map<String, ChannelDecorator> decorators = new HashMap<>();

    @Override
    public ChannelDecorator using(String decoratorIdentity) {
        return decorators.get(decoratorIdentity);
    }

    @Override
    public DecoratorNamespace use(String identity, ChannelDecorator decorator) {
        decorators.put(identity, decorator);
        return this;
    }

    @Override
    @Pattern("[a-z0-9_\\-.]+")
    public @NotNull String namespace() {
        return CHANNEL_NAMESPACE;
    }
}
