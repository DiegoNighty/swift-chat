package dev.diegonighty.swiftchat.core.structure.audience;

public interface AudienceAdapter {

    AudienceFactory to(AudienceType type);

    AudienceAdapter register(AudienceType type, AudienceFactory factory);

}
