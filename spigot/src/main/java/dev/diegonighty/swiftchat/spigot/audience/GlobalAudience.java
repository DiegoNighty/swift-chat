package dev.diegonighty.swiftchat.spigot.audience;

import dev.diegonighty.swiftchat.core.audience.AudienceFactory;
import dev.diegonighty.swiftchat.core.audience.AudienceType;
import dev.diegonighty.swiftchat.core.audience.ChannelAudience;
import dev.diegonighty.swiftchat.core.configuration.Configuration;
import dev.diegonighty.swiftchat.core.recipient.ChannelRecipient;
import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import org.bukkit.Bukkit;

import java.util.List;

public record GlobalAudience(
        RecipientAdapter adapter
) implements ChannelAudience {

    @Override
    public AudienceType type() {
        return AudienceType.GLOBAL;
    }

    @Override
    public List<ChannelRecipient> recipients() {
        return Bukkit.getOnlinePlayers().stream()
                .map(adapter::adapt)
                .toList();
    }

    public static class Factory implements AudienceFactory {

        private final RecipientAdapter playerRecipientAdapter;

        public Factory(RecipientAdapter playerRecipientAdapter) {
            this.playerRecipientAdapter = playerRecipientAdapter;
        }

        @Override
        public ChannelAudience create(AudienceType type, Configuration source) {
            return new GlobalAudience(playerRecipientAdapter);
        }
    }

}
