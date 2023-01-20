package com.github.diegonighty.swiftchat.api.decorator.chain;

import com.github.diegonighty.swiftchat.api.decorator.ComposedDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.GlobalDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PermitDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PersonalDecorator;

import java.util.List;

public interface DecoratorChainProvider {

    Iterable<PermitDecorator> permits(DecoratorChainSequence sequence);

    Iterable<GlobalDecorator> globals(DecoratorChainSequence sequence);

    Iterable<PersonalDecorator> personals(DecoratorChainSequence sequence);

    List<ComposedDecorator> all();

    List<ComposedDecorator> permits();

    List<ComposedDecorator> globals();

    List<ComposedDecorator> personals();

}
