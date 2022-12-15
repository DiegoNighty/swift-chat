package dev.diegonighty.swiftchat.spigot.audience;

import dev.diegonighty.swiftchat.core.audience.AudienceFactory;
import dev.diegonighty.swiftchat.core.audience.AudienceType;
import dev.diegonighty.swiftchat.core.audience.ChannelAudience;
import dev.diegonighty.swiftchat.core.configuration.Configuration;
import dev.diegonighty.swiftchat.core.recipient.ChannelRecipient;
import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public record GroupAudience(List<UUID> audience, RecipientAdapter adapter) implements ChannelAudience {

    private final static String FIELD = "members";

    @Override
    public AudienceType type() {
        return AudienceType.GROUP;
    }

    @Override
    public Collection<ChannelRecipient> recipients() {
        return audience.stream()
                .map(adapter::adapt)
                .toList();
    }

    @Override
    public String field() {
        return FIELD;
    }

    @Override
    public boolean persistent() {
        return true;
    }

    public static class Factory implements AudienceFactory {

        private final RecipientAdapter uuidRecipientAdapter;

        public Factory(RecipientAdapter uuidRecipientAdapter) {
            this.uuidRecipientAdapter = uuidRecipientAdapter;
        }

        @Override
        public ChannelAudience create(AudienceType type, Configuration source) {
            return new GroupAudience(source.getList(FIELD, UUID.class), uuidRecipientAdapter);
        }
    }
}
