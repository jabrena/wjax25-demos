package info.jab.cis194.homework4;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Exercise 3: Currying and Partial Application
 * 
 * This class implements currying and partial application techniques
 * that allow transforming multi-argument functions into chains of
 * single-argument functions. These techniques are fundamental to
 * functional programming and enable powerful composition patterns.
 */
public class Exercise3 {

    /**
     * Curries a two-argument function into a chain of single-argument functions.
     * Given f: (A, B) -> C, returns a function g: A -> (B -> C).
     * 
     * @param <A> the type of the first argument
     * @param <B> the type of the second argument
     * @param <C> the type of the result
     * @param f the two-argument function to curry
     * @return a curried function that takes the first argument and returns a function
     */
    public static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> f) {
        return a -> b -> f.apply(a, b);
    }

    /**
     * Uncurries a chain of single-argument functions into a two-argument function.
     * Given f: A -> (B -> C), returns a function g: (A, B) -> C.
     * 
     * @param <A> the type of the first argument
     * @param <B> the type of the second argument
     * @param <C> the type of the result
     * @param f the curried function to uncurry
     * @return an uncurried function that takes two arguments
     */
    public static <A, B, C> BiFunction<A, B, C> uncurry(Function<A, Function<B, C>> f) {
        return (a, b) -> f.apply(a).apply(b);
    }

    /**
     * Partially applies the first argument to a two-argument function.
     * Given f: (A, B) -> C and a value a, returns a function g: B -> C.
     * 
     * @param <A> the type of the first argument
     * @param <B> the type of the second argument
     * @param <C> the type of the result
     * @param f the two-argument function
     * @param a the value to partially apply as the first argument
     * @return a function that takes the second argument and returns the result
     */
    public static <A, B, C> Function<B, C> partialApply(BiFunction<A, B, C> f, A a) {
        return b -> f.apply(a, b);
    }

    /**
     * Partially applies the second argument to a two-argument function.
     * Given f: (A, B) -> C and a value b, returns a function g: A -> C.
     * 
     * @param <A> the type of the first argument
     * @param <B> the type of the second argument
     * @param <C> the type of the result
     * @param f the two-argument function
     * @param b the value to partially apply as the second argument
     * @return a function that takes the first argument and returns the result
     */
    public static <A, B, C> Function<A, C> partialApplySecond(BiFunction<A, B, C> f, B b) {
        return a -> f.apply(a, b);
    }

    /**
     * Curries a three-argument function into a chain of single-argument functions.
     * Given f: (A, B, C) -> D, returns a function g: A -> (B -> (C -> D)).
     * 
     * @param <A> the type of the first argument
     * @param <B> the type of the second argument
     * @param <C> the type of the third argument
     * @param <D> the type of the result
     * @param f the three-argument function to curry
     * @return a curried function that takes the first argument and returns a curried function
     */
    public static <A, B, C, D> Function<A, Function<B, Function<C, D>>> curry3(TriFunction<A, B, C, D> f) {
        return a -> b -> c -> f.apply(a, b, c);
    }

    /**
     * Partially applies the first two arguments to a three-argument function.
     * Given f: (A, B, C) -> D and values a, b, returns a function g: C -> D.
     * 
     * @param <A> the type of the first argument
     * @param <B> the type of the second argument
     * @param <C> the type of the third argument
     * @param <D> the type of the result
     * @param f the three-argument function
     * @param a the value to partially apply as the first argument
     * @param b the value to partially apply as the second argument
     * @return a function that takes the third argument and returns the result
     */
    public static <A, B, C, D> Function<C, D> partialApply3(TriFunction<A, B, C, D> f, A a, B b) {
        return c -> f.apply(a, b, c);
    }

    /**
     * Creates a function that applies a given function to a fixed value.
     * This is useful for creating constant functions or for partial application.
     * 
     * @param <A> the type of the input
     * @param <B> the type of the output
     * @param f the function to apply
     * @param value the fixed value to apply the function to
     * @return a function that always applies f to the given value
     */
    public static <A, B> Function<A, B> constant(Function<A, B> f, A value) {
        return x -> f.apply(value);
    }

    /**
     * Creates a function that ignores its input and always returns a constant value.
     * 
     * @param <A> the type of the input (ignored)
     * @param <B> the type of the output
     * @param value the constant value to return
     * @return a function that always returns the given value
     */
    public static <A, B> Function<A, B> constValue(B value) {
        return x -> value;
    }

    // Helper interface for three-argument functions
    @FunctionalInterface
    public interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}