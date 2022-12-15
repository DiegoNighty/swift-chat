package com.github.diegonighty.swiftchat.api.decorator.chain;

import com.github.diegonighty.swiftchat.api.decorator.DecoratorPriority;
import com.github.diegonighty.swiftchat.api.decorator.type.GlobalDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PermitDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PersonalDecorator;

public interface ChannelDecoratorChain extends DecoratorChainProvider {

    ChannelDecoratorChain permit(PermitDecorator permit, DecoratorPriority priority);

    ChannelDecoratorChain decorate(GlobalDecorator decorator, DecoratorPriority priority);

    ChannelDecoratorChain decorate(PersonalDecorator decorator, DecoratorPriority priority);

    default ChannelDecoratorChain decorate(GlobalDecorator decorator) {
        return decorate(decorator, DecoratorPriority.NORMAL);
    }

    default ChannelDecoratorChain decorate(PersonalDecorator decorator) {
        return decorate(decorator, DecoratorPriority.NORMAL);
    }

    default ChannelDecoratorChain permit(PermitDecorator decorator) {
        return permit(decorator, DecoratorPriority.NORMAL);
    }

}
