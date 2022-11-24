package dev.diegonighty.swiftchat.core.structure.audience;

public record AudienceType(String name) {

    public static final AudienceType GROUP = new AudienceType("GROUP");
    public static final AudienceType GLOBAL = new AudienceType("GLOBAL");

}
