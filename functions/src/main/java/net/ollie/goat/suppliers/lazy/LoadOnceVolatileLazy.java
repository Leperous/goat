package net.ollie.goat.suppliers.lazy;

import static java.util.Objects.requireNonNull;
import java.util.function.Supplier;

import javax.annotation.concurrent.ThreadSafe;

/**
 *
 * @author Ollie
 */
@ThreadSafe
public class LoadOnceVolatileLazy<T> implements Lazy<T> {

    private volatile Supplier<T> holder;

    protected LoadOnceVolatileLazy(final Supplier<? extends T> supplier) {
        this.holder = new Loader(supplier);
    }

    @Override
    public T get() {
        return holder.get();
    }

    private final class Loader implements Supplier<T> {

        private final Supplier<? extends T> supplier;

        Loader(final Supplier<? extends T> supplier) {
            this.supplier = requireNonNull(supplier);
        }

        @Override
        public T get() {
            synchronized (this) {
                holder = this == holder
                        ? new Value(supplier.get())
                        : holder;
            }
            return holder.get();
        }

    }

    private final class Value implements Supplier<T> {

        private final T value;

        Value(final T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }

    }

}
