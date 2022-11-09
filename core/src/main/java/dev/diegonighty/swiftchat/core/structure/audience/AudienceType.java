package dev.diegonighty.swiftchat.core.structure.audience;

public record AudienceType(String type) {

    public static final AudienceType SERIALIZABLE_GROUP = new AudienceType("SERIALIZABLE_GROUP");
    public static final AudienceType GROUP = new AudienceType("GROUP");
    public static final AudienceType GLOBAL = new AudienceType("GLOBAL");

}
