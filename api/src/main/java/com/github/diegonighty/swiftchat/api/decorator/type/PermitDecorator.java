package com.github.diegonighty.swiftchat.api.decorator.type;

import com.github.diegonighty.swiftchat.api.audience.ChannelRecipient;
import com.github.diegonighty.swiftchat.api.message.MessageContext;
import net.kyori.adventure.text.Component;

public interface PermitDecorator extends Decorator {

    PermitDecoratorResult permit(MessageContext context, ChannelRecipient recipient);

    record PermitDecoratorResult(boolean result, Component reason) {
        public static final PermitDecoratorResult ALLOWED =
                new PermitDecoratorResult(true, Component.empty());

        public static final PermitDecoratorResult DENIED =
                new PermitDecoratorResult(false, Component.empty());

        public static PermitDecoratorResult denied(Component reason) {
            return new PermitDecoratorResult(false, reason);
        }

        public static PermitDecoratorResult from(boolean check) {
            return check ? ALLOWED : DENIED;
        }

    }
}
