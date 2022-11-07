package dev.diegonighty.swiftchat.core.structure.decorator.chain;

import dev.diegonighty.swiftchat.core.annotation.Annotations;
import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;
import dev.diegonighty.swiftchat.core.structure.decorator.annotation.Decorator;
import dev.diegonighty.swiftchat.core.structure.decorator.namespace.DecoratorNamespace;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class MarkedChannelDecoratorChain implements ChannelDecoratorChain {

    private final DecoratorNamespace decoratorNamespace;

    private final static ToIntFunction<Class<? extends ChannelDecorator>> EXTRACTOR = (clazz) ->
            Annotations.extractOrDefault(
                    clazz.getAnnotation(Decorator.class),
                    Decorator::priority,
                    DecoratorPriority.NORMAL
            ).order();

    public MarkedChannelDecoratorChain(DecoratorNamespace decoratorNamespace) {
        this.decoratorNamespace = decoratorNamespace;
    }

    @Override
    public List<ChannelDecorator> decorate(MessageContext ctx) {
        var channel = ctx.channel();

        return channel.decorators()
                .stream()
                .sorted(Comparator.comparingInt(EXTRACTOR))
                .map(decoratorNamespace::using)
                .toList();
    }

}
