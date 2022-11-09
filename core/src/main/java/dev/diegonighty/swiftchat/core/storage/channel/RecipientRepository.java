package dev.diegonighty.swiftchat.core.storage.channel;

import dev.diegonighty.swiftchat.core.storage.GenericRepository;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

import java.util.UUID;

public interface RecipientRepository extends GenericRepository<String, ChannelRecipient> {

    ChannelRecipient findByName(String name);

    ChannelRecipient findByUuid(UUID uuid);

}
