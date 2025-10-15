package info.jab.cis194.homework4;

import java.util.function.Function;

/**
 * Exercise 2: Function Composition
 * 
 * This class implements function composition operations that allow
 * combining functions in a pipeline-like manner. Function composition
 * is a fundamental concept in functional programming that enables
 * elegant, composable code patterns.
 */
public class Exercise2 {

    /**
     * Composes two functions f and g such that the result is f(g(x)).
     * This is the mathematical definition of function composition.
     * 
     * @param <A> the input type of the outer function
     * @param <B> the output type of the inner function and input type of the outer function
     * @param <C> the output type of the outer function
     * @param f the outer function (applied second)
     * @param g the inner function (applied first)
     * @return a new function that applies g first, then f
     */
    public static <A, B, C> Function<A, C> compose(Function<B, C> f, Function<A, B> g) {
        return x -> f.apply(g.apply(x));
    }

    /**
     * Creates a pipeline of functions where the result is g(f(x)).
     * This is the opposite of compose - it applies functions from left to right.
     * 
     * @param <A> the input type of the first function
     * @param <B> the output type of the first function and input type of the second function
     * @param <C> the output type of the second function
     * @param f the first function (applied first)
     * @param g the second function (applied second)
     * @return a new function that applies f first, then g
     */
    public static <A, B, C> Function<A, C> pipe(Function<A, B> f, Function<B, C> g) {
        return x -> g.apply(f.apply(x));
    }

    /**
     * Creates the identity function that returns its input unchanged.
     * This is useful as a neutral element in function composition.
     * 
     * @param <T> the type of the input and output
     * @return the identity function
     */
    public static <T> Function<T, T> identity() {
        return x -> x;
    }

    /**
     * Composes multiple functions from right to left.
     * The result is f1(f2(f3(...fn(x)))).
     * 
     * @param <T> the type of the input and output
     * @param functions the functions to compose
     * @return a new function that applies all functions from right to left
     */
    @SafeVarargs
    public static <T> Function<T, T> composeAll(Function<T, T>... functions) {
        if (functions.length == 0) {
            return identity();
        }
        
        Function<T, T> result = functions[functions.length - 1];
        for (int i = functions.length - 2; i >= 0; i--) {
            result = compose(result, functions[i]);
        }
        return result;
    }

    /**
     * Creates a pipeline of multiple functions from left to right.
     * The result is fn(...f3(f2(f1(x)))).
     * 
     * @param <T> the type of the input and output
     * @param functions the functions to pipe
     * @return a new function that applies all functions from left to right
     */
    @SafeVarargs
    public static <T> Function<T, T> pipeAll(Function<T, T>... functions) {
        if (functions.length == 0) {
            return identity();
        }
        
        Function<T, T> result = functions[0];
        for (int i = 1; i < functions.length; i++) {
            result = pipe(result, functions[i]);
        }
        return result;
    }

    /**
     * Creates a function that applies a given function n times.
     * 
     * @param <T> the type of the input and output
     * @param f the function to apply
     * @param n the number of times to apply the function
     * @return a new function that applies f n times
     */
    public static <T> Function<T, T> repeat(Function<T, T> f, int n) {
        if (n <= 0) {
            return identity();
        }
        
        Function<T, T> result = f;
        for (int i = 1; i < n; i++) {
            result = compose(result, f);
        }
        return result;
    }
}