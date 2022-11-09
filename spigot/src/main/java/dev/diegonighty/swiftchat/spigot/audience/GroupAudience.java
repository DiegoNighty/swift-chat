package dev.diegonighty.swiftchat.spigot.audience;

import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceType;
import dev.diegonighty.swiftchat.core.structure.audience.ChannelAudience;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public record GroupAudience(AudienceType type, List<UUID> audience, RecipientAdapter adapter) implements ChannelAudience {
    @Override
    public Collection<ChannelRecipient> recipients() {
        return audience.stream()
                .map(adapter::adapt)
                .toList();
    }
}
