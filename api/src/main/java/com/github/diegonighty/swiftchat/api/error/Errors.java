package com.github.diegonighty.swiftchat.api.error;

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

    public static <T, E extends RuntimeException> T trySupply(
            ExceptionableSupplier<T, ?> supplier, Supplier<E> error
    ) {
        try {
            return supplier.get();
        } catch (Exception e) {
            throw error.get();
        }
    }

    public interface ExceptionableSupplier<T, E extends RuntimeException> {
        T get() throws E;
    }

}
