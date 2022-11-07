package dev.diegonighty.swiftchat.core.structure.decorator.sequence;

import dev.diegonighty.swiftchat.core.common.Tuple;
import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

import static dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain.*;

public class MarkedDecoratorSequence implements DecoratorChainSequence {

    private final static ToIntFunction<Tuple<DecoratorPriority, ?>> EXTRACTOR = tuple -> tuple.first().order();

    @Override
    public Iterable<PermitDecorator> orderPermits(List<Tuple<DecoratorPriority, PermitDecorator>> decorators) {
        return decorators.stream()
                .sorted(Comparator.comparingInt(EXTRACTOR))
                .map(Tuple::second)
                .toList();
    }

    @Override
    public Iterable<PersonalDecorator> orderPersonals(List<Tuple<DecoratorPriority, PersonalDecorator>> decorators) {
        return decorators.stream()
                .sorted(Comparator.comparingInt(EXTRACTOR))
                .map(Tuple::second)
                .toList();
    }

    @Override
    public Iterable<GlobalDecorator> orderGlobals(List<Tuple<DecoratorPriority, GlobalDecorator>> decorators) {
        return decorators.stream()
                .sorted(Comparator.comparingInt(EXTRACTOR))
                .map(Tuple::second)
                .toList();
    }
}
