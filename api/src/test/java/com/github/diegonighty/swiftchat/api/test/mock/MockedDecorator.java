package com.github.diegonighty.swiftchat.api.test.mock;

import com.github.diegonighty.swiftchat.api.decorator.ChannelDecorator;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorNamespace;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MockedDecorator implements DecoratorNamespace {

    private final Map<String, ChannelDecorator> decorators = new HashMap<>();

    @Override
    public @NotNull String namespace() {
        return "test";
    }

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
