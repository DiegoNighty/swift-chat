package com.github.diegonighty.swiftchat.core.decorator;

import com.github.diegonighty.swiftchat.api.decorator.ComposedDecorator;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorPriority;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;
import com.github.diegonighty.swiftchat.api.decorator.chain.DecoratorChainSequence;
import com.github.diegonighty.swiftchat.api.decorator.type.Decorator;
import com.github.diegonighty.swiftchat.api.decorator.type.GlobalDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PermitDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PersonalDecorator;

import java.util.ArrayList;
import java.util.List;

public class ChannelDecoratorChainImpl implements ChannelDecoratorChain {

    private final List<ComposedDecorator> permitDecorators = new ArrayList<>();
    private final List<ComposedDecorator> globalDecorators = new ArrayList<>();
    private final List<ComposedDecorator> personalDecorators = new ArrayList<>();

    @Override
    public ChannelDecoratorChain permit(PermitDecorator permit, DecoratorPriority priority) {
        permitDecorators.add(new ComposedDecorator(permit, priority));
        return this;
    }

    @Override
    public ChannelDecoratorChain decorate(GlobalDecorator decorator, DecoratorPriority priority) {
        globalDecorators.add(new ComposedDecorator(decorator, priority));
        return this;
    }

    @Override
    public ChannelDecoratorChain decorate(PersonalDecorator decorator, DecoratorPriority priority) {
        personalDecorators.add(new ComposedDecorator(decorator, priority));
        return this;
    }

    @Override
    public ChannelDecoratorChain remove(Decorator decorator) {
        permitDecorators.removeIf(composedDecorator -> composedDecorator.decorator().equals(decorator));
        globalDecorators.removeIf(composedDecorator -> composedDecorator.decorator().equals(decorator));
        personalDecorators.removeIf(composedDecorator -> composedDecorator.decorator().equals(decorator));
        return this;
    }

    @Override
    public Iterable<PermitDecorator> permits(DecoratorChainSequence sequence) {
        return sequence.orderPermits(permitDecorators);
    }

    @Override
    public Iterable<GlobalDecorator> globals(DecoratorChainSequence sequence) {
        return sequence.orderGlobals(globalDecorators);
    }

    @Override
    public Iterable<PersonalDecorator> personals(DecoratorChainSequence sequence) {
        return sequence.orderPersonals(personalDecorators);
    }

    @Override
    public List<ComposedDecorator> all() {
        return new ArrayList<>() {{
            addAll(permitDecorators);
            addAll(globalDecorators);
            addAll(personalDecorators);
        }};
    }

    @Override
    public List<ComposedDecorator> permits() {
        return permitDecorators;
    }

    @Override
    public List<ComposedDecorator> globals() {
        return globalDecorators;
    }

    @Override
    public List<ComposedDecorator> personals() {
        return personalDecorators;
    }


}
