package dev.diegonighty.swiftchat.core.structure.channel;

import dev.diegonighty.swiftchat.core.common.Metadata;
import dev.diegonighty.swiftchat.core.storage.GenericStorable;
import dev.diegonighty.swiftchat.core.structure.audience.ChannelAudience;
import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;

import java.util.List;

public record ChannelInformation(
        String id,
        String name,
        Metadata metadata,
        ChannelAudience audience,
        List<Class<? extends ChannelDecorator>> decorators
) implements GenericStorable<String> {}
