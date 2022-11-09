package dev.diegonighty.swiftchat.spigot.audience;

import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.storage.serializer.GenericReader;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceFactory;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceType;
import dev.diegonighty.swiftchat.core.structure.audience.ChannelAudience;

import java.util.UUID;

public class GroupAudienceFactory implements AudienceFactory {

    private final RecipientAdapter uuidRecipientAdapter;

    public GroupAudienceFactory(RecipientAdapter uuidRecipientAdapter) {
        this.uuidRecipientAdapter = uuidRecipientAdapter;
    }

    @Override
    public ChannelAudience create(AudienceType type, GenericReader<?> source) {
        return new GroupAudience(type, source.readList("audience", UUID.class), uuidRecipientAdapter);
    }
}
