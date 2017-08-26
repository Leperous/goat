package net.ollie.goat.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 *
 * @author Ollie
 */
public interface Provider<K, V> {

    @CheckForNull
    V get(K key);

    @Nonnull
    default Optional<V> maybeGet(final K key) {
        return Optional.ofNullable(this.get(key));
    }

    @Nonnull
    default V require(final K key) {
        return Objects.requireNonNull(this.get(key), () -> "Missing [" + key + "]!");
    }

    @Nonnull
    default <X extends Exception> V require(final K key, final Function<? super K, ? extends X> ifAbsent) throws X {
        final V value = this.get(key);
        if (value == null) {
            throw ifAbsent.apply(key);
        }
        return value;
    }

    @Nonnull
    default Map<K, V> getAll(final Set<K> keys) {
        final Map<K, V> all = new HashMap<>(keys.size());
        for (final K key : keys) {
            final V value = this.get(key);
            if (value != null) {
                all.put(key, value);
            }
        }
        return all;
    }

}
