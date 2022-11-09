package dev.diegonighty.swiftchat.spigot.audience;

import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceType;
import dev.diegonighty.swiftchat.core.structure.audience.ChannelAudience;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;
import org.bukkit.Bukkit;

import java.util.List;

public record GlobalAudience(
        AudienceType type,
        RecipientAdapter adapter
) implements ChannelAudience {

    @Override
    public List<ChannelRecipient> recipients() {
        return Bukkit.getOnlinePlayers().stream()
                .map(adapter::adapt)
                .toList();
    }

}
