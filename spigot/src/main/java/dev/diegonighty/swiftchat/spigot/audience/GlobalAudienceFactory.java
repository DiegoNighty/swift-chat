package dev.diegonighty.swiftchat.spigot.audience;

import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.storage.serializer.GenericReader;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceFactory;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceType;
import dev.diegonighty.swiftchat.core.structure.audience.ChannelAudience;

public class GlobalAudienceFactory implements AudienceFactory {

    private final RecipientAdapter playerRecipientAdapter;

    public GlobalAudienceFactory(RecipientAdapter playerRecipientAdapter) {
        this.playerRecipientAdapter = playerRecipientAdapter;
    }

    @Override
    public ChannelAudience create(AudienceType type, GenericReader<?> source) {
        return new GlobalAudience(type, playerRecipientAdapter);
    }
}
