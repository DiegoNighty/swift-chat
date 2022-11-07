package dev.diegonighty.swiftchat.core.structure.decorator;

public class DecoratorPriority {

    public static final DecoratorPriority LOW = new DecoratorPriority(100);
    public static final DecoratorPriority NORMAL = new DecoratorPriority(250);
    public static final DecoratorPriority HIGH = new DecoratorPriority(500);

    public static DecoratorPriority of(int order) {
        return new DecoratorPriority(order);
    }

    private final int order;

    private DecoratorPriority(int order) {
        this.order = order;
    }

    public int order() {
        return order;
    }

}
