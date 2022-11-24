package dev.diegonighty.swiftchat.core.structure.decorator.namespace;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;

import java.util.HashMap;
import java.util.Iterator;
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

    @Override
    public Iterator<ChannelDecorator> iterator() {
        return decorators.values()
                .iterator();
    }
}
