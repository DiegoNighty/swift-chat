package com.github.diegonighty.swiftchat.api.decorator;

import net.kyori.adventure.key.Namespaced;

import java.util.List;
import java.util.Objects;

public interface DecoratorNamespace extends Namespaced {

    default ChannelDecorator using(Class<? extends ChannelDecorator> decorator) {
        return using(decorator.getSimpleName());
    }

    default List<ChannelDecorator> using(List<String> keys) {
        return keys.stream()
                .map(this::using)
                .filter(Objects::nonNull)
                .toList();
    }

    default DecoratorNamespace use(Class<? extends ChannelDecorator> decoratorIdentity, ChannelDecorator decorator) {
        return use(decoratorIdentity.getSimpleName(), decorator);
    }

    ChannelDecorator using(String decoratorIdentity);

    DecoratorNamespace use(String identity, ChannelDecorator decorator);

}
