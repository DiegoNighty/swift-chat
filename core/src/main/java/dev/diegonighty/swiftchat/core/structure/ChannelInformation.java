package dev.diegonighty.swiftchat.core.structure;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;

import java.util.List;

public interface ChannelInformation {

    List<Class<? extends ChannelDecorator>> decorators();

}
