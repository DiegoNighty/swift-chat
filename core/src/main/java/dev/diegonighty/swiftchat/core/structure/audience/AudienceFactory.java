package dev.diegonighty.swiftchat.core.structure.audience;

import dev.diegonighty.swiftchat.core.storage.serializer.GenericReader;

public interface AudienceFactory {

    ChannelAudience create(AudienceType type, GenericReader<?> source);

}
