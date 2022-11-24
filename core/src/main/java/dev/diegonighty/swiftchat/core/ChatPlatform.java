package dev.diegonighty.swiftchat.core;

import dev.diegonighty.swiftchat.core.channel.ChannelFactory;
import dev.diegonighty.swiftchat.core.channel.ChannelManager;
import dev.diegonighty.swiftchat.core.error.platform.PlatformAlreadyEnabledError;
import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.storage.channel.ChannelRepository;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceAdapter;
import dev.diegonighty.swiftchat.core.structure.decorator.namespace.DecoratorNamespace;
import dev.diegonighty.swiftchat.core.structure.message.MessageRendererProvider;

public interface ChatPlatform {

    void enable() throws PlatformAlreadyEnabledError;

    MessageRendererProvider messageRenderer();

    AudienceAdapter audienceAdapter();

    RecipientAdapter recipientAdapter();

    DecoratorNamespace decoratorNamespace();

    ChannelManager channelManager();

    ChannelFactory channelFactory();

    ChannelRepository channelRepository();

}
