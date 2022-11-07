package dev.diegonighty.swiftchat.core.structure.decorator.chain;

import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain.GlobalDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain.PermitDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain.PersonalDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.sequence.DecoratorChainSequence;

public interface DecoratorChainProvider {

    Iterable<PermitDecorator> permits(DecoratorChainSequence sequence);

    Iterable<GlobalDecorator> globals(DecoratorChainSequence sequence);

    Iterable<PersonalDecorator> personals(DecoratorChainSequence sequence);

}
