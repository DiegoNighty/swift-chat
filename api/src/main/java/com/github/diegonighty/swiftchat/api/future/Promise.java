package com.github.diegonighty.swiftchat.api.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A promise is a future that can be completed.
 * highly inspired by the Promise implementation from the Lucko's Helper library.
 * <a href="https://github.com/lucko/helper/blob/master/helper/src/main/java/me/lucko/helper/promise/HelperPromise.java">see</a>
 * @param <T> the type of the value
 */
public class Promise<T> {

    protected final CompletableFuture<T> backing;
    protected AtomicBoolean cancelled = new AtomicBoolean(false);

    protected Promise(CompletableFuture<T> backing) {
        this.backing = backing;
    }

    protected Promise(CompletableFuture<T> backing, AtomicBoolean cancelled) {
        this.backing = backing;
        this.cancelled = cancelled;
    }

    public <R> Promise<R> map(Function<T, R> mapper) {
        Promise<R> compose = empty(this);

        backing.whenComplete((result, error) -> {
            if (cancelled.get()) {
                return;
            }

            if (error != null) {
                compose.backing.completeExceptionally(error);
                return;
            }

            try {
                R mapped = mapper.apply(result);
                compose.backing.complete(mapped);
            } catch (Throwable throwable) {
                compose.backing.completeExceptionally(throwable);
            }
        });

        return compose;
    }

    public <R> Promise<R> flatMap(Function<T, Promise<R>> mapper) {
        Promise<R> compose = empty(this);

        backing.whenComplete((result, error) -> {
            if (cancelled.get()) {
                return;
            }

            if (error != null) {
                compose.backing.completeExceptionally(error);
                return;
            }

            Promise<R> mapped = mapper.apply(result);

            if (mapped == null) {
                compose.backing.complete(null);
                return;
            }

            mapped.backing.thenAccept(compose.backing::complete);
        });

        return compose;
    }

    public Promise<T> switchEmpty(Supplier<T> supplier) {
        Promise<T> compose = empty(this);

        backing.whenComplete((result, error) -> {
            if (cancelled.get()) {
                return;
            }

            if (error != null) {
                compose.backing.completeExceptionally(error);
                return;
            }

            if (result == null) {
                try {
                    T mapped = supplier.get();
                    compose.backing.complete(mapped);
                } catch (Throwable throwable) {
                    compose.backing.completeExceptionally(throwable);
                }
            } else {
                compose.backing.complete(result);
            }
        });

        return compose;
    }

    public Promise<T> filter(Predicate<T> filter) {
        Promise<T> compose = empty(this);

        backing.whenComplete((result, error) -> {
            if (cancelled.get()) {
                return;
            }

            if (error != null) {
                compose.backing.completeExceptionally(error);
                return;
            }

            try {
                if (filter.test(result)) {
                    compose.backing.complete(result);
                } else {
                    compose.cancelled.set(true);
                }
            } catch (Throwable throwable) {
                compose.backing.completeExceptionally(throwable);
            }
        });

        return compose;
    }

    public Promise<T> switchError(Function<Throwable, T> consumer) {
        Promise<T> compose = empty(this);

        backing.whenComplete((result, error) -> {
            if (cancelled.get()) {
                return;
            }

            if (error == null) {
                compose.backing.complete(result);
                return;
            }

            try {
                T mapped = consumer.apply(error);
                compose.backing.complete(mapped);
            } catch (Throwable throwable) {
                compose.backing.completeExceptionally(throwable);
            }
        });

        return compose;
    }

    public Promise<T> subscribe(Consumer<T> consumer) {
        Promise<T> compose = empty(this);

        backing.whenComplete((result, error) -> {
            if (cancelled.get()) {
                return;
            }

            if (error != null) {
                compose.backing.completeExceptionally(error);
                return;
            }

            try {
                consumer.accept(result);
                compose.backing.complete(result);
            } catch (Throwable throwable) {
                compose.backing.completeExceptionally(throwable);
            }
        });

        return compose;
    }

    public static <T> Promise<T> empty(Promise<?> parent) {
        return new Promise<>(new CompletableFuture<>(), parent.cancelled);
    }

    public static Promise<Void> blank() {
        return new Promise<>(CompletableFuture.completedFuture(null));
    }

    public static <T> Promise<T> fromSupplier(Supplier<T> supplier) {
        return new Promise<>(CompletableFuture.supplyAsync(supplier));
    }

    public static Promise<Void> fromRunnable(Runnable runnable) {
        return new Promise<>(CompletableFuture.runAsync(runnable));
    }

    public static <T> Promise<T> fromSupplier(Supplier<T> supplier, Executor executor) {
        return new Promise<>(CompletableFuture.supplyAsync(supplier, executor));
    }

    public static Promise<Void> fromRunnable(Runnable runnable, Executor executor) {
        return new Promise<>(CompletableFuture.runAsync(runnable, executor));
    }

}

