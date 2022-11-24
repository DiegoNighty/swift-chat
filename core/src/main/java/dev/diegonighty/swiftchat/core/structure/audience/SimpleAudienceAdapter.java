package dev.diegonighty.swiftchat.core.structure.audience;

import java.util.HashMap;
import java.util.Map;

public class SimpleAudienceAdapter implements AudienceAdapter {

    private final Map<AudienceType, AudienceFactory> factories = new HashMap<>();

    @Override
    public AudienceFactory to(AudienceType type) {
        return factories.get(type);
    }

    @Override
    public AudienceAdapter register(AudienceType type, AudienceFactory factory) {
        factories.put(type, factory);
        return this;
    }
}
