package com.github.diegonighty.swiftchat.api.decorator;

import com.github.diegonighty.swiftchat.api.decorator.type.Decorator;

public record ComposedDecorator(Decorator decorator, DecoratorPriority priority) {
    public static ComposedDecorator of(Decorator decorator, DecoratorPriority priority) {
        return new ComposedDecorator(decorator, priority);
    }

    public static ComposedDecorator of(Decorator decorator) {
        return new ComposedDecorator(decorator, DecoratorPriority.NORMAL);
    }
}
