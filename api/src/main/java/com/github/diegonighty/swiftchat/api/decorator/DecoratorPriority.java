package com.github.diegonighty.swiftchat.api.decorator;

public record DecoratorPriority(int order) {
    public static DecoratorPriority of(int order) {
        return new DecoratorPriority(order);
    }

    public static final DecoratorPriority LOW = new DecoratorPriority(100);
    public static final DecoratorPriority NORMAL = new DecoratorPriority(250);
    public static final DecoratorPriority HIGH = new DecoratorPriority(500);
}
