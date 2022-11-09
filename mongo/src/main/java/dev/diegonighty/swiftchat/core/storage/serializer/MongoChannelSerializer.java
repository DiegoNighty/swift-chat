package dev.diegonighty.swiftchat.core.storage.serializer;

import dev.diegonighty.swiftchat.core.common.Metadata;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceAdapter;
import dev.diegonighty.swiftchat.core.structure.audience.AudienceType;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import dev.diegonighty.swiftchat.core.structure.decorator.ChannelDecorator;
import org.bson.Document;

public class MongoChannelSerializer implements GenericSerializer<ChannelInformation, Document> {

    private final AudienceAdapter audienceAdapter;

    public MongoChannelSerializer(AudienceAdapter audienceAdapter) {
        this.audienceAdapter = audienceAdapter;
    }

    @Override
    public ChannelInformation read(Document document) {
        DocumentReader reader = DocumentReader.create(document);

        return new ChannelInformation(
                reader.readString("_id"),
                reader.readString("name"),
                Metadata.of(reader.getChild("metadata")),
                reader.readChild("audience",
                        childReader -> {
                            AudienceType type = new AudienceType(childReader.readString("type"));

                            return audienceAdapter.to(type)
                                    .create(type, childReader);
                        }),
                reader.readClazzList("decorators", ChannelDecorator.class)
        );
    }

    @Override
    public Document write(ChannelInformation channelInformation) {
        return null;
    }
}
