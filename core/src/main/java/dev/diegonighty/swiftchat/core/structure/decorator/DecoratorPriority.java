package dev.diegonighty.swiftchat.core.structure.decorator;

public enum DecoratorPriority {

    LOW(0),
    NORMAL(1),
    HIGH(2);

    private final int order;

    DecoratorPriority(int order) {
        this.order = order;
    }

    public int order() {
        return order;
    }

}
