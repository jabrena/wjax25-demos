package info.jab.cis194.homework4;

import java.util.function.Function;
import java.util.function.BiFunction;

public class Exercise2 {

    /**
     * Curry function: converts a function of two arguments into a function that takes
     * the first argument and returns a function that takes the second argument.
     * This is the Java equivalent of Haskell's curry function.
     * 
     * Type: ((a,b) -> c) -> (a -> (b -> c))
     */
    public static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> f) {
        return a -> b -> f.apply(a, b);
    }

    /**
     * Uncurry function: converts a curried function back to a function of two arguments.
     * This is the Java equivalent of Haskell's uncurry function.
     * 
     * Type: (a -> (b -> c)) -> ((a,b) -> c)
     */
    public static <A, B, C> BiFunction<A, B, C> uncurry(Function<A, Function<B, C>> f) {
        return (a, b) -> f.apply(a).apply(b);
    }

    /**
     * Partial application for a 3-argument curried function.
     * Applies the first argument and returns a 2-argument curried function.
     * 
     * Type: (a -> (b -> (c -> d))) -> a -> (b -> (c -> d))
     */
    public static <A, B, C, D> Function<B, Function<C, D>> partialApply1(
            Function<A, Function<B, Function<C, D>>> f, A a) {
        return f.apply(a);
    }

    /**
     * Partial application for a 3-argument curried function.
     * Applies the first two arguments and returns a 1-argument function.
     * 
     * Type: (a -> (b -> (c -> d))) -> a -> b -> (c -> d)
     */
    public static <A, B, C, D> Function<C, D> partialApply2(
            Function<A, Function<B, Function<C, D>>> f, A a, B b) {
        return f.apply(a).apply(b);
    }

    /**
     * Schönfinkel function: another name for curry.
     * Named after Moses Schönfinkel who first discovered this concept.
     * 
     * Type: ((a,b) -> c) -> (a -> (b -> c))
     */
    public static <A, B, C> Function<A, Function<B, C>> schonfinkel(BiFunction<A, B, C> f) {
        return curry(f);
    }

    /**
     * Unschönfinkel function: another name for uncurry.
     * 
     * Type: (a -> (b -> c)) -> ((a,b) -> c)
     */
    public static <A, B, C> BiFunction<A, B, C> unschonfinkel(Function<A, Function<B, C>> f) {
        return uncurry(f);
    }
}