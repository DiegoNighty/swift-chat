package com.github.diegonighty.swiftchat.api.decorator;

import com.github.diegonighty.swiftchat.api.decorator.type.Decorator;
import com.github.diegonighty.swiftchat.api.error.Errors;
import com.github.diegonighty.swiftchat.api.error.decorator.InheritExplicitDecoratorError;

public record ComposedDecorator(Decorator decorator, DecoratorPriority priority) {
    public static ComposedDecorator of(Decorator decorator, DecoratorPriority priority) {
        return new ComposedDecorator(decorator, priority);
    }

    public static ComposedDecorator of(Decorator decorator) {
        return new ComposedDecorator(decorator, DecoratorPriority.NORMAL);
    }

    public <T extends Decorator> T inherit(Class<T> toInherit) {
        return Errors.trySupply(
                () -> toInherit.cast(decorator),
                () -> new InheritExplicitDecoratorError(toInherit)
        );
    }
}
