package dev.diegonighty.swiftchat.core.channel;

import dev.diegonighty.swiftchat.core.structure.channel.Channel;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.factory.DecoratorChainFactory;
import dev.diegonighty.swiftchat.core.structure.decorator.sequence.DecoratorChainSequence;

public class ChannelFactory {

    private final DecoratorChainFactory chainFactory;
    private final DecoratorChainSequence sequence;

    public ChannelFactory(DecoratorChainFactory chainFactory, DecoratorChainSequence sequence) {
        this.chainFactory = chainFactory;
        this.sequence = sequence;
    }

    public Channel from(ChannelInformation information) {
        return new BasicChannel(information, chainFactory, sequence);
    }
}
