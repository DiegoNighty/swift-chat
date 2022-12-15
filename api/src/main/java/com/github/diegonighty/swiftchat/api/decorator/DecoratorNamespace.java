package com.github.diegonighty.swiftchat.api.decorator;

import net.kyori.adventure.key.Namespaced;

public interface DecoratorNamespace extends Namespaced {

    default ChannelDecorator using(Class<? extends ChannelDecorator> decorator) {
        return using(decorator.getSimpleName());
    }

    default DecoratorNamespace use(Class<? extends ChannelDecorator> decoratorIdentity, ChannelDecorator decorator) {
        return use(decoratorIdentity.getSimpleName(), decorator);
    }

    ChannelDecorator using(String decoratorIdentity);

    DecoratorNamespace use(String identity, ChannelDecorator decorator);

}
