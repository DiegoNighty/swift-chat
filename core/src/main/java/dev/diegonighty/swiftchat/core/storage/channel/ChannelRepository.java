package dev.diegonighty.swiftchat.core.storage.channel;

import dev.diegonighty.swiftchat.core.storage.GenericRepository;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;

public interface ChannelRepository extends GenericRepository<String, ChannelInformation> {

    ChannelInformation findByName(String name);

}
