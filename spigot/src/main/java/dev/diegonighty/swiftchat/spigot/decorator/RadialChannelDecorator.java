package dev.diegonighty.swiftchat.spigot.decorator;

import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;
import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;
import dev.diegonighty.swiftchat.core.structure.decorator.chain.ChannelDecoratorChain;
import dev.diegonighty.swiftchat.spigot.StructureAdapter;
import org.bukkit.entity.Player;

public class RadialChannelDecorator implements ChannelDecorator {

    @Override
    public ChannelDecoratorChain decorate(ChannelDecoratorChain chain) {
        return chain
                .decorate((ctx, recipient) -> {
                    Player sender = StructureAdapter.adapt(ctx.message().sender());
                    ctx.metadata()
                            .set();
                })
                .permit((ctx, recipient) -> {
                    Player sender = StructureAdapter.adapt(ctx.message().sender());
                    Player receiver = StructureAdapter.adapt(recipient);

                    if (!sender.getWorld().getName().equals(receiver.getWorld().getName())) {
                        return false;
                    }

                    int radius = ctx.channelMetadata()
                            .meta()
                            .asInt("options.chat.radius");

                    return sender.getLocation()
                            .distanceSquared(receiver.getLocation())
                            <= radius;
                }, DecoratorPriority.LOW);
    }


}
