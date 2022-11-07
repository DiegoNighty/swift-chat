package dev.diegonighty.swiftchat.core.structure.decorator.chain;

import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;
import dev.diegonighty.swiftchat.core.structure.message.MessageContext;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;

public interface ChannelDecoratorChain extends DecoratorChainProvider {

    default ChannelDecoratorChain decorate(GlobalDecorator decorator) {
        return decorate(decorator, DecoratorPriority.NORMAL);
    }

    default ChannelDecoratorChain decorate(PersonalDecorator decorator) {
        return decorate(decorator, DecoratorPriority.NORMAL);
    }

    default ChannelDecoratorChain permit(PermitDecorator decorator) {
        return permit(decorator, DecoratorPriority.NORMAL);
    }

    ChannelDecoratorChain permit(PermitDecorator permit, DecoratorPriority priority);

    ChannelDecoratorChain decorate(GlobalDecorator decorator, DecoratorPriority priority);

    ChannelDecoratorChain decorate(PersonalDecorator decorator, DecoratorPriority priority);

    interface PermitDecorator {
        boolean permit(MessageContext ctx, ChannelRecipient recipient);
    }

    interface GlobalDecorator {
        void decorate(MessageContext ctx);
    }

    interface PersonalDecorator {
        void decorate(MessageContext ctx, ChannelRecipient recipient);
    }

}
