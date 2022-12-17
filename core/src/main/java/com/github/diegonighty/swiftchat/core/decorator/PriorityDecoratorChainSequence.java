package com.github.diegonighty.swiftchat.core.decorator;

import com.github.diegonighty.swiftchat.api.decorator.ComposedDecorator;
import com.github.diegonighty.swiftchat.api.decorator.chain.DecoratorChainSequence;
import com.github.diegonighty.swiftchat.api.decorator.type.GlobalDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PermitDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PersonalDecorator;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class PriorityDecoratorChainSequence implements DecoratorChainSequence {

    private final static ToIntFunction<ComposedDecorator> EXTRACTOR = compose -> compose.priority().order();

    @Override
    public Iterable<PermitDecorator> orderPermits(List<ComposedDecorator> decorators) {
        return decorators.stream()
                .sorted(Comparator.comparingInt(EXTRACTOR))
                .map(composedDecorator -> composedDecorator.inherit(PermitDecorator.class))
                .toList();
    }

    @Override
    public Iterable<PersonalDecorator> orderPersonals(List<ComposedDecorator> decorators) {
        return decorators.stream()
                .sorted(Comparator.comparingInt(EXTRACTOR))
                .map(composedDecorator -> composedDecorator.inherit(PersonalDecorator.class))
                .toList();
    }

    @Override
    public Iterable<GlobalDecorator> orderGlobals(List<ComposedDecorator> decorators) {
        return decorators.stream()
                .sorted(Comparator.comparingInt(EXTRACTOR))
                .map(composedDecorator -> composedDecorator.inherit(GlobalDecorator.class))
                .toList();
    }
}
