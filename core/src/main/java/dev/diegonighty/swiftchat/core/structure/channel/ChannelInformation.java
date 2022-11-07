package dev.diegonighty.swiftchat.core.structure.channel;

import dev.diegonighty.swiftchat.core.structure.audience.ChannelAudience;
import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;

import java.util.List;

public interface ChannelInformation {

    String name();

    List<Class<? extends ChannelDecorator>> decorators();

    ChannelAudience audience();

}
