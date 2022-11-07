package dev.diegonighty.swiftchat.core.structure.audience;

import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

import java.util.Collection;

public interface ChannelAudience {

    AudienceType type();

    Collection<ChannelRecipient> recipients();

}
