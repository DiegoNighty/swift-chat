package dev.diegonighty.swiftchat.spigot.decorator;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain;
import dev.diegonighty.swiftchat.spigot.StructureAdapter;

public class RadialChannelDecorator implements ChannelDecorator {

    @Override
    public ChannelDecoratorChain decorate(ChannelDecoratorChain chain) {
        return chain
                .permit((ctx, recipient) -> {
                    var sender = StructureAdapter.adapt(ctx.message().sender());
                    var receiver = StructureAdapter.adapt(recipient);

                    if (!sender.getWorld().getName().equals(receiver.getWorld().getName())) {
                        return false;
                    }

                    var radius = ctx.channel().metadata()
                            .asInt("options.chat.radius");

                    return sender.getLocation()
                            .distanceSquared(receiver.getLocation())
                            <= radius;
                }, DecoratorPriority.LOW);
    }

}
