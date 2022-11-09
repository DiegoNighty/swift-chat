package dev.diegonighty.swiftchat.core.storage;

import com.mongodb.client.MongoCollection;
import dev.diegonighty.swiftchat.core.storage.channel.ChannelRepository;
import dev.diegonighty.swiftchat.core.storage.serializer.GenericSerializer;
import dev.diegonighty.swiftchat.core.structure.channel.ChannelInformation;
import org.bson.Document;

public class MongoChannelRepository
        extends MongoGenericRepository<String, ChannelInformation>
        implements ChannelRepository {

    public MongoChannelRepository(
            GenericSerializer<ChannelInformation, Document> serializer,
            MongoCollection<Document> collection
    ) {
        super(serializer, collection);
    }

    @Override
    public ChannelInformation findByName(String name) {
        return findByFieldValue("name", name);
    }
}
