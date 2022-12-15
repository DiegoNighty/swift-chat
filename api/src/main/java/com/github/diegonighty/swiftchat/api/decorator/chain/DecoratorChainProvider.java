package com.github.diegonighty.swiftchat.api.decorator.chain;

import com.github.diegonighty.swiftchat.api.decorator.type.GlobalDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PermitDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PersonalDecorator;

public interface DecoratorChainProvider {

    Iterable<PermitDecorator> permits(DecoratorChainSequence sequence);

    Iterable<GlobalDecorator> globals(DecoratorChainSequence sequence);

    Iterable<PersonalDecorator> personals(DecoratorChainSequence sequence);

}
