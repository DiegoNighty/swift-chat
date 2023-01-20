package com.github.diegonighty.swiftchat.core.storage;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Consumer;

public interface Storage<I, E> {

    IDExtractor<E, I> extract();

    @Nullable
    E read(I id);

    void update(E entity);

    void delete(E entity);

    default void handle(I id, Consumer<E> action) {
        Optional.ofNullable(read(id))
                .ifPresent(action
                        .andThen(this::update)
                );
    }

    interface IDExtractor<E, I> {
            I from(E entity);
    }

}
