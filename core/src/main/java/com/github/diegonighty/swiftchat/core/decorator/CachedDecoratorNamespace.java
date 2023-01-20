package com.github.diegonighty.swiftchat.core.decorator;

import com.github.diegonighty.swiftchat.api.decorator.ChannelDecorator;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorNamespace;

import java.util.HashMap;
import java.util.Map;

public class CachedDecoratorNamespace implements DecoratorNamespace {

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
}
