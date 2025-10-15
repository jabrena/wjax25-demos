package info.jab.cis194.homework3;

import java.util.function.Function;

/**
 * Maybe represents an optional value that may or may not be present.
 * This is the Java equivalent of the Haskell Maybe a type from the lecture.
 */
public abstract class Maybe<T> {
    
    /**
     * Nothing constructor - represents absence of a value
     */
    public static class Nothing<T> extends Maybe<T> {
        @Override
        public String toString() {
            return "Nothing";
        }
        
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Nothing;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
    }
    
    /**
     * Just constructor - represents presence of a value
     */
    public static class Just<T> extends Maybe<T> {
        private final T value;
        
        public Just(T value) {
            this.value = value;
        }
        
        public T getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return "Just(" + value + ")";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Just)) return false;
            Just<?> other = (Just<?>) obj;
            return value.equals(other.value);
        }
        
        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
    
    /**
     * Safe head function that returns Maybe instead of crashing
     */
    public static <T> Maybe<T> safeHead(List<T> list) {
        if (list instanceof List.E) {
            return new Nothing<>();
        } else if (list instanceof List.C) {
            List.C<T> cons = (List.C<T>) list;
            return new Just<>(cons.getHead());
        }
        throw new IllegalArgumentException("Unknown List type");
    }
    
    /**
     * Safe tail function that returns Maybe instead of crashing
     */
    public static <T> Maybe<List<T>> safeTail(List<T> list) {
        if (list instanceof List.E) {
            return new Nothing<>();
        } else if (list instanceof List.C) {
            List.C<T> cons = (List.C<T>) list;
            return new Just<>(cons.getTail());
        }
        throw new IllegalArgumentException("Unknown List type");
    }
    
    /**
     * Map a function over a Maybe value
     */
    public static <A, B> Maybe<B> mapMaybe(Function<A, B> f, Maybe<A> maybe) {
        if (maybe instanceof Nothing) {
            return new Nothing<>();
        } else if (maybe instanceof Just) {
            Just<A> just = (Just<A>) maybe;
            return new Just<>(f.apply(just.getValue()));
        }
        throw new IllegalArgumentException("Unknown Maybe type");
    }
    
    /**
     * Check if Maybe contains a value
     */
    public static <T> boolean isJust(Maybe<T> maybe) {
        return maybe instanceof Just;
    }
    
    /**
     * Check if Maybe is Nothing
     */
    public static <T> boolean isNothing(Maybe<T> maybe) {
        return maybe instanceof Nothing;
    }
    
    /**
     * Get the value from Just, or return default if Nothing
     */
    public static <T> T fromMaybe(T defaultValue, Maybe<T> maybe) {
        if (maybe instanceof Just) {
            Just<T> just = (Just<T>) maybe;
            return just.getValue();
        } else {
            return defaultValue;
        }
    }
}