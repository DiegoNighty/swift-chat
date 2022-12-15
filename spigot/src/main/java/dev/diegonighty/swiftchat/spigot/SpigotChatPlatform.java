package dev.diegonighty.swiftchat.spigot;

import dev.diegonighty.swiftchat.core.ChatPlatform;
import dev.diegonighty.swiftchat.core.audience.AudienceAdapter;
import dev.diegonighty.swiftchat.core.audience.SimpleAudienceAdapter;
import dev.diegonighty.swiftchat.core.channel.ChannelFactory;
import dev.diegonighty.swiftchat.core.channel.ChannelManager;
import dev.diegonighty.swiftchat.core.decorator.chain.factory.DecoratorChainFactory;
import dev.diegonighty.swiftchat.core.decorator.namespace.CachedDecoratorNamespace;
import dev.diegonighty.swiftchat.core.decorator.namespace.DecoratorNamespace;
import dev.diegonighty.swiftchat.core.decorator.sequence.DecoratorChainSequence;
import dev.diegonighty.swiftchat.core.decorator.sequence.MarkedDecoratorSequence;
import dev.diegonighty.swiftchat.core.error.platform.PlatformAlreadyEnabledError;
import dev.diegonighty.swiftchat.core.message.MessageRendererProvider;
import dev.diegonighty.swiftchat.core.recipient.RecipientAdapter;
import dev.diegonighty.swiftchat.core.storage.ChannelRepository;
import dev.diegonighty.swiftchat.spigot.channel.CachedChannelManager;
import dev.diegonighty.swiftchat.spigot.message.FlatMessageRenderer;
import dev.diegonighty.swiftchat.spigot.recipient.PlayerRecipientAdapter;

public class SpigotChatPlatform implements ChatPlatform {

    private DecoratorNamespace decoratorNamespace;

    private ChannelFactory channelFactory;
    private ChannelManager channelManager;
    private ChannelRepository channelRepository;

    private MessageRendererProvider messageRendererProvider;
    private AudienceAdapter audienceAdapter;
    private RecipientAdapter recipientAdapter;

    @Override
    public void enable() throws PlatformAlreadyEnabledError {
        DecoratorChainSequence decoratorChainSequence = new MarkedDecoratorSequence();

        this.decoratorNamespace = new CachedDecoratorNamespace();

        DecoratorChainFactory decoratorChainFactory = new DecoratorChainFactory(decoratorNamespace);

        this.channelFactory = new ChannelFactory(decoratorChainFactory, decoratorChainSequence);
        this.channelRepository = storageProvider.createChannelRepository();
        this.channelManager = CachedChannelManager.create(channelFactory, channelRepository);

        this.messageRendererProvider = new MessageRendererProvider();
        messageRendererProvider.setRenderer(new FlatMessageRenderer());

        this.audienceAdapter = new SimpleAudienceAdapter();
        this.recipientAdapter = new PlayerRecipientAdapter(messageRendererProvider);
    }

    @Override
    public MessageRendererProvider messageRenderer() {
        return messageRendererProvider;
    }

    @Override
    public AudienceAdapter audienceAdapter() {
        return audienceAdapter;
    }

    @Override
    public RecipientAdapter recipientAdapter() {
        return recipientAdapter;
    }

    @Override
    public DecoratorNamespace decoratorNamespace() {
        return decoratorNamespace;
    }

    @Override
    public ChannelManager channelManager() {
        return channelManager;
    }

    @Override
    public ChannelFactory channelFactory() {
        return channelFactory;
    }

    @Override
    public ChannelRepository channelRepository() {
        return channelRepository;
    }
}
