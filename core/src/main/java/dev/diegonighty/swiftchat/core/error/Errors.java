package dev.diegonighty.swiftchat.core.error;

import java.util.function.Supplier;

public class Errors {

    public static <E extends RuntimeException> void expects(
            boolean condition, Supplier<E> error
    ) throws E {
        if (!condition) {
            throw error.get();
        }
    }

    public static <E extends RuntimeException> void expectsNonNull(
            Object nullable, Supplier<E> error
    ) throws E {
        expects(nullable != null, error);
    }

    public static <T> T swapIfNull(T object, T fallback) {
        return object == null ? fallback : object;
    }

}
