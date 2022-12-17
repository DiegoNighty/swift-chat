package com.github.diegonighty.swiftchat.api.error.decorator;

public class InheritExplicitDecoratorError extends RuntimeException {

    public InheritExplicitDecoratorError(Class<?> toInherit) {
        super("The decorator is not of type " + toInherit.getName());
    }

}
