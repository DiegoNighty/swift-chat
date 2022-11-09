package dev.diegonighty.swiftchat.spigot;

import dev.diegonighty.swiftchat.core.ChatPlatform;
import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceType;
import dev.diegonighty.swiftchat.spigot.audience.GlobalAudienceFactory;
import dev.diegonighty.swiftchat.spigot.audience.GroupAudienceFactory;
import dev.diegonighty.swiftchat.spigot.recipient.UUIDRecipientAdapter;

public class SwiftChatPlugin {

    public void onUse(ChatPlatform platform) {
        RecipientAdapter playerAdapter = platform
                .adapter()
                .recipient();

        RecipientAdapter uuidAdapter = new UUIDRecipientAdapter(playerAdapter);

        platform.adapter()
                .audience()
                .register(AudienceType.GLOBAL, new GlobalAudienceFactory(playerAdapter))
                .register(AudienceType.GROUP, new GroupAudienceFactory(uuidAdapter));

        platform.adapter()
                .audience()
                .to(AudienceType.GLOBAL)
                .create(AudienceType.GLOBAL, null);
    }

}
