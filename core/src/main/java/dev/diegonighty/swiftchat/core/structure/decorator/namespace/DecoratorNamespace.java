package dev.diegonighty.swiftchat.core.structure.decorator.namespace;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;

public interface DecoratorNamespace extends Iterable<ChannelDecorator> {

    ChannelDecorator using(Class<? extends ChannelDecorator> decorator);

    DecoratorNamespace use(Class<? extends ChannelDecorator> decoratorIdentity, ChannelDecorator decorator);

}
