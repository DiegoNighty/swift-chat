package com.github.diegonighty.swiftchat.api.test;

import com.github.diegonighty.swiftchat.api.channel.Channel;
import com.github.diegonighty.swiftchat.api.channel.ChannelSpec;
import com.github.diegonighty.swiftchat.api.decorator.ChannelDecorator;
import com.github.diegonighty.swiftchat.api.decorator.ComposedDecorator;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorNamespace;
import com.github.diegonighty.swiftchat.api.decorator.DecoratorPriority;
import com.github.diegonighty.swiftchat.api.decorator.chain.ChannelDecoratorChain;
import com.github.diegonighty.swiftchat.api.decorator.chain.DecoratorChainSequence;
import com.github.diegonighty.swiftchat.api.decorator.type.GlobalDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PermitDecorator;
import com.github.diegonighty.swiftchat.api.decorator.type.PersonalDecorator;
import com.github.diegonighty.swiftchat.api.message.MessageContext;
import com.github.diegonighty.swiftchat.api.structure.Metadata;
import com.github.diegonighty.swiftchat.api.test.mock.MockedChannel;
import com.github.diegonighty.swiftchat.api.test.mock.MockedDecorator;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChannelDecoratorTest {

    @Test
    void testChannelDecorator() {
        DecoratorNamespace namespace = new MockedDecorator();
        namespace.use(ChannelDecoratorChainImpl.Decorator.class, new ChannelDecoratorChainImpl.Decorator());

        ChannelDecoratorChain chain = new ChannelDecoratorChainImpl();
        chain = new ChannelDecoratorChainImpl.Decorator().decorate(chain);

        Channel channel = new MockedChannel(new MockedChannel.MockedChannelSpec(Metadata.empty(), chain), new DecoratorChainSequence() {
            @Override
            public Iterable<PermitDecorator> orderPermits(List<ComposedDecorator> decorators) {
                return decorators.stream()
                        .map(composedDecorator -> (PermitDecorator) composedDecorator.decorator())
                        .toList();
            }

            @Override
            public Iterable<PersonalDecorator> orderPersonals(List<ComposedDecorator> decorators) {
                return decorators.stream()
                        .map(composedDecorator -> (PersonalDecorator) composedDecorator.decorator())
                        .toList();
            }

            @Override
            public Iterable<GlobalDecorator> orderGlobals(List<ComposedDecorator> decorators) {
                return decorators.stream()
                        .map(composedDecorator -> (GlobalDecorator) composedDecorator.decorator())
                        .toList();
            }
        });

        channel.postMessage(new MessageContext() {
            @Override
            public ChannelSpec channel() {
                return channel.spec();
            }

            private Component message = Component.text("Hello world!");

            @Override
            public Component editableMessage() {
                return message;
            }

            @Override
            public void editMessage(EditableComponent component) {
                message = component.edit(message);
            }

            @Override
            public Component originalMessage() {
                return Component.text("Hello world!");
            }

            @Override
            public Metadata metadata() {
                return Metadata.empty();
            }

            @Override
            public MessageContext copy() {
                return this;
            }
        });
    }

    public static class ChannelDecoratorChainImpl implements ChannelDecoratorChain {

        private final List<ComposedDecorator> permitDecorators = new ArrayList<>();
        private final List<ComposedDecorator> globalDecorators = new ArrayList<>();
        private final List<ComposedDecorator> personalDecorators = new ArrayList<>();

        @Override
        public ChannelDecoratorChain permit(PermitDecorator permit, DecoratorPriority priority) {
            permitDecorators.add(new ComposedDecorator(permit, priority));
            return this;
        }

        @Override
        public ChannelDecoratorChain decorate(GlobalDecorator decorator, DecoratorPriority priority) {
            globalDecorators.add(new ComposedDecorator(decorator, priority));
            return this;
        }

        @Override
        public ChannelDecoratorChain decorate(PersonalDecorator decorator, DecoratorPriority priority) {
            personalDecorators.add(new ComposedDecorator(decorator, priority));
            return this;
        }

        @Override
        public ChannelDecoratorChain remove(com.github.diegonighty.swiftchat.api.decorator.type.Decorator decorator) {
            permitDecorators.removeIf(composedDecorator -> composedDecorator.decorator().equals(decorator));
            globalDecorators.removeIf(composedDecorator -> composedDecorator.decorator().equals(decorator));
            personalDecorators.removeIf(composedDecorator -> composedDecorator.decorator().equals(decorator));
            return this;
        }

        @Override
        public Iterable<PermitDecorator> permits(DecoratorChainSequence sequence) {
            return sequence.orderPermits(permitDecorators);
        }

        @Override
        public Iterable<GlobalDecorator> globals(DecoratorChainSequence sequence) {
            return sequence.orderGlobals(globalDecorators);
        }

        @Override
        public Iterable<PersonalDecorator> personals(DecoratorChainSequence sequence) {
            return sequence.orderPersonals(personalDecorators);
        }

        @Override
        public List<ComposedDecorator> all() {
            return new ArrayList<>() {{
                addAll(permitDecorators);
                addAll(globalDecorators);
                addAll(personalDecorators);
            }};
        }

        static class Decorator implements ChannelDecorator {
            @Override
            public ChannelDecoratorChain decorate(ChannelDecoratorChain chain) {
                return chain
                        .decorate((ctx) -> {
                            System.out.println("aaa");

                            ctx.editMessage(
                                    (component) ->
                                            component.replaceText(
                                                    builder ->
                                                            builder.match("Hello")
                                                                    .replacement(Component.text("Hello world!"))
                                    )
                            );
                        });
            }
        }

    }
}
