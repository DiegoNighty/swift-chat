package dev.diegonighty.swiftchat.spigot.recipient;

import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.recipient.ChannelRecipient;
import org.bukkit.Bukkit;

import java.util.UUID;

public class UUIDRecipientAdapter implements RecipientAdapter {

    private final RecipientAdapter recipientAdapter;

    public UUIDRecipientAdapter(RecipientAdapter playerRecipientAdapter) {
        this.recipientAdapter = playerRecipientAdapter;
    }

    @Override
    public ChannelRecipient adapt(Object adapt) {
        var id = (UUID) adapt;

        return recipientAdapter.adapt(Bukkit.getPlayer(id));
    }
}
