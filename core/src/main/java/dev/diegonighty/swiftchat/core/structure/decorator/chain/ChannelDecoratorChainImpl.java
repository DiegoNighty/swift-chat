package dev.diegonighty.swiftchat.core.structure.decorator.chain;

import dev.diegonighty.swiftchat.core.common.Tuple;
import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;
import dev.diegonighty.swiftchat.core.structure.decorator.sequence.DecoratorChainSequence;

import java.util.ArrayList;
import java.util.List;

public class ChannelDecoratorChainImpl implements ChannelDecoratorChain {

    private final List<Tuple<DecoratorPriority, PermitDecorator>> permitDecorators = new ArrayList<>();
    private final List<Tuple<DecoratorPriority, GlobalDecorator>> globalDecorators = new ArrayList<>();
    private final List<Tuple<DecoratorPriority, PersonalDecorator>> personalDecorators = new ArrayList<>();

    @Override
    public ChannelDecoratorChain permit(PermitDecorator permit, DecoratorPriority priority) {
        permitDecorators.add(Tuple.build(priority, permit));
        return this;
    }

    @Override
    public ChannelDecoratorChain decorate(GlobalDecorator decorator, DecoratorPriority priority) {
        globalDecorators.add(Tuple.build(priority, decorator));
        return this;
    }

    @Override
    public ChannelDecoratorChain decorate(PersonalDecorator decorator, DecoratorPriority priority) {
        personalDecorators.add(Tuple.build(priority, decorator));
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
}
