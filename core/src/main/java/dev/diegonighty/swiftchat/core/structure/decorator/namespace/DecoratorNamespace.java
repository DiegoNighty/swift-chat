package dev.diegonighty.swiftchat.core.structure.decorator.namespace;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;

public interface DecoratorNamespace extends Iterable<ChannelDecorator> {

    default ChannelDecorator using(Class<? extends ChannelDecorator> decorator) {
        return using(decorator.getSimpleName());
    }

    default DecoratorNamespace use(Class<? extends ChannelDecorator> decoratorIdentity, ChannelDecorator decorator) {
        return use(decoratorIdentity.getSimpleName(), decorator);
    }

    ChannelDecorator using(String decoratorIdentity);

    DecoratorNamespace use(String identity, ChannelDecorator decorator);

}
