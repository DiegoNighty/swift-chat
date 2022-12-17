package com.github.diegonighty.swiftchat.core.storage;

import java.util.Optional;
import java.util.function.Consumer;

public interface Storage<I, E> {

    I extractId(E entity);

    E read(I id);

    void update(E entity);

    void delete(E entity);

    default void handle(I id, Consumer<E> action) {
        Optional.of(read(id))
                .ifPresent(action
                        .andThen(this::update)
                );
    }

}
