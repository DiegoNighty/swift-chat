package dev.diegonighty.swiftchat.core.storage.serializer;

import dev.diegonighty.swiftchat.core.common.Metadata;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceAdapter;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceType;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.recipient.ChannelRecipient;
import org.bson.Document;

public class MongoChannelSerializer implements GenericSerializer<ChannelInformation, Document> {

    private final AudienceAdapter audienceAdapter;

    public MongoChannelSerializer(AudienceAdapter audienceAdapter) {
        this.audienceAdapter = audienceAdapter;
    }

    @Override
    public ChannelInformation read(Document document) {
        var reader = DocumentReader.create(document);

        return new ChannelInformation(
                reader.readString("_id"),
                reader.readString("name"),
                Metadata.of(reader.getChild("metadata")),
                reader.readChild("audience",
                        childReader -> {
                            var type = new AudienceType(childReader.readString("type"));

                            return audienceAdapter.to(type)
                                    .create(type, childReader);
                        }),
                reader.readList("decorators", String.class)
        );
    }

    @Override
    public Document write(ChannelInformation channelInformation) {
        var writer = DocumentWriter.create(channelInformation);

        var audience = channelInformation.audience();

        var audienceWriter = DocumentWriter.empty()
                .write("type", audience.type().name())
                .write("persistent", audience.persistent());

        if (audience.persistent()) {
            audienceWriter.write(
                    audience.field(),
                    audience.recipients().stream()
                            .map(ChannelRecipient::id)
                            .toList()
            );
        }

        return writer
                .write("name", channelInformation.name())
                .write("metadata", channelInformation.metadata())
                .write("audience", audienceWriter.document())
                .write("decorators", channelInformation.decorators())
                .build();
    }
}
