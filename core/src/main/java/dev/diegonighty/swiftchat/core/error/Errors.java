package dev.diegonighty.swiftchat.core.error;

public class Errors {

    public static <E extends RuntimeException> void expects(
            boolean condition, E exception
    ) throws E {
        if (!condition) {
            throw exception;
        }
    }


}
