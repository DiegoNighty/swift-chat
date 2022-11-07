package dev.diegonighty.swiftchat.core.structure.decorator.sequence;

import dev.diegonighty.swiftchat.core.common.Tuple;
import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain.GlobalDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain.PersonalDecorator;

import java.util.List;

import static dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain.PermitDecorator;

public interface DecoratorChainSequence {

    Iterable<PermitDecorator> orderPermits(
            List<Tuple<DecoratorPriority, PermitDecorator>> decorators
    );

    Iterable<PersonalDecorator> orderPersonals(
            List<Tuple<DecoratorPriority, PersonalDecorator>> decorators
    );

    Iterable<GlobalDecorator> orderGlobals(
            List<Tuple<DecoratorPriority, GlobalDecorator>> decorators
    );

}
