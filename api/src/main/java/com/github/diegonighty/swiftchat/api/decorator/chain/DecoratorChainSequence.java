package com.github.diegonighty.swiftchat.api.decorator.chain;

import com.github.diegonighty.swiftchat.api.decorator.ComposedDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.GlobalDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PermitDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PersonalDecorator;

import java.util.List;

public interface DecoratorChainSequence {

    Iterable<PermitDecorator> orderPermits(
            List<ComposedDecorator> decorators
    );

    Iterable<PersonalDecorator> orderPersonals(
            List<ComposedDecorator> decorators
    );

    Iterable<GlobalDecorator> orderGlobals(
            List<ComposedDecorator> decorators
    );

}
