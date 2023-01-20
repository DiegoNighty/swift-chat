package com.github.diegonighty.swiftchat.core.channel;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorConverter;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;
import com.github.diegonighty.swiftchat.api.metadata.Metadata;
import net.kyori.adventure.text.Component;

import java.util.List;

public record CommonChannelSpec(
        String id,
        Component name,
        Metadata metadata,
        List<ChannelRecipient> audience,
        List<String> decoratorKeys
) implements ChannelSpec {

    @Override
    public ChannelDecoratorChain chain(DecoratorConverter converter) {
        return converter.buildChain(this);
    }

}
