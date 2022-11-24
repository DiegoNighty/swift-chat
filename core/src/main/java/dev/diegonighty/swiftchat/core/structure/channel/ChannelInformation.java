package dev.diegonighty.swiftchat.core.structure.channel;

import dev.diegonighty.swiftchat.core.common.Metadata;
import dev.diegonighty.swiftchat.core.error.Errors;
import dev.diegonighty.swiftchat.core.storage.GenericStorable;
import dev.diegonighty.swiftchat.core.structure.audience.ChannelAudience;
import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record ChannelInformation(
        String id,
        String name,
        Metadata metadata,
        ChannelAudience audience,
        List<String> decorators
) implements GenericStorable<String> {

    public static ChannelInformationBuilder with() {
        return new ChannelInformationBuilder();
    }

    public static class ChannelInformationBuilder {

            private String id;
            private String name;
            private Metadata metadata = Metadata.empty();
            private ChannelAudience audience;
            private final List<String> decorators = new ArrayList<>();

            public ChannelInformationBuilder id(String id) {
                this.id = id;
                return this;
            }

            public ChannelInformationBuilder id(UUID id) {
                this.id = id.toString();
                return this;
            }

            public ChannelInformationBuilder name(String name) {
                this.name = name;
                return this;
            }

            public ChannelInformationBuilder metadata(Metadata metadata) {
                this.metadata = metadata;
                return this;
            }

            public ChannelInformationBuilder audience(ChannelAudience audience) {
                this.audience = audience;
                return this;
            }

            public ChannelInformationBuilder decorators(List<Class<? extends ChannelDecorator>> decorators) {
                this.decorators.addAll(
                        decorators.stream()
                                .map(Class::getSimpleName)
                                .toList()
                );

                return this;
            }

            public ChannelInformationBuilder plainDecorators(List<String> decorators) {
                this.decorators.addAll(decorators);
                return this;
            }

            public ChannelInformation build() {
                Errors.expectsNonNull(id, () -> new IllegalArgumentException("id can't be null"));
                Errors.expectsNonNull(audience, () -> new IllegalArgumentException("audience can't be null"));

                return new ChannelInformation(id, Errors.swapIfNull(name, id), metadata, audience, decorators);
            }
    }



}
