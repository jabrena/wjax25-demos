package info.jab.cis194.homework3;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Polymorphic List represents a list of elements of any type using a recursive data structure.
 * This is the Java equivalent of the Haskell List t type from the lecture.
 */
public abstract class List<T> {
    
    /**
     * Empty list constructor
     */
    public static class E<T> extends List<T> {
        @Override
        public String toString() {
            return "E";
        }
        
        @Override
        public boolean equals(Object obj) {
            return obj instanceof E;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
    }
    
    /**
     * Non-empty list constructor with head and tail
     */
    public static class C<T> extends List<T> {
        private final T head;
        private final List<T> tail;
        
        public C(T head, List<T> tail) {
            this.head = head;
            this.tail = tail;
        }
        
        public T getHead() {
            return head;
        }
        
        public List<T> getTail() {
            return tail;
        }
        
        @Override
        public String toString() {
            return "C(" + head + ", " + tail + ")";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof C)) return false;
            C<?> other = (C<?>) obj;
            return head.equals(other.head) && tail.equals(other.tail);
        }
        
        @Override
        public int hashCode() {
            return head.hashCode() + 31 * tail.hashCode();
        }
    }
    
    /**
     * Apply a function to every element in the list
     */
    public static <A, B> List<B> mapList(Function<A, B> f, List<A> list) {
        if (list instanceof E) {
            return new E<>();
        } else if (list instanceof C) {
            C<A> cons = (C<A>) list;
            return new C<>(f.apply(cons.getHead()), mapList(f, cons.getTail()));
        }
        throw new IllegalArgumentException("Unknown List type");
    }
    
    /**
     * Filter elements based on a predicate
     */
    public static <T> List<T> filterList(Predicate<T> p, List<T> list) {
        if (list instanceof E) {
            return new E<>();
        } else if (list instanceof C) {
            C<T> cons = (C<T>) list;
            if (p.test(cons.getHead())) {
                return new C<>(cons.getHead(), filterList(p, cons.getTail()));
            } else {
                return filterList(p, cons.getTail());
            }
        }
        throw new IllegalArgumentException("Unknown List type");
    }
    
    /**
     * Convert a list to a Java List for easier testing
     */
    public static <T> java.util.List<T> toJavaList(List<T> list) {
        java.util.List<T> result = new java.util.ArrayList<>();
        List<T> current = list;
        while (current instanceof C) {
            C<T> cons = (C<T>) current;
            result.add(cons.getHead());
            current = cons.getTail();
        }
        return result;
    }
    
    /**
     * Create a List from a Java List
     */
    public static <T> List<T> fromJavaList(java.util.List<T> javaList) {
        List<T> result = new E<>();
        for (int i = javaList.size() - 1; i >= 0; i--) {
            result = new C<>(javaList.get(i), result);
        }
        return result;
    }
}