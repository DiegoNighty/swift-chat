package com.github.diegonighty.swiftchat.core.audience;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import net.kyori.adventure.audience.Audience;

@FunctionalInterface
public interface AudienceConverter {

    Audience convert(ChannelRecipient recipient);

}
