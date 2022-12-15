package dev.diegonighty.swiftchat.spigot.recipient;

import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.recipient.ChannelRecipient;
import dev.diegonighty.swiftchat.core.message.MessageRendererProvider;
import org.bukkit.entity.Player;

public class PlayerRecipientAdapter implements RecipientAdapter {

    private final MessageRendererProvider rendererProvider;

    public PlayerRecipientAdapter(MessageRendererProvider rendererProvider) {
        this.rendererProvider = rendererProvider;
    }

    @Override
    public ChannelRecipient adapt(Object player) {
        return new PlayerRecipient((Player) player, rendererProvider.renderer());
    }
}
