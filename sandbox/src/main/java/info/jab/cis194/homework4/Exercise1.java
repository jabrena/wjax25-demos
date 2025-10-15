package info.jab.cis194.homework4;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise1 {

    /**
     * Filters a list to keep only elements greater than 100.
     * This demonstrates higher-order functions using lambda expressions.
     */
    public static List<Integer> greaterThan100(List<Integer> xs) {
        return filter(xs, x -> x > 100);
    }

    /**
     * Function composition: (f . g) x = f(g(x))
     * This is the Java equivalent of Haskell's function composition operator (.)
     */
    public static <A, B, C> Function<A, C> compose(Function<B, C> f, Function<A, B> g) {
        return x -> f.apply(g.apply(x));
    }

    /**
     * Pipeline function that checks if the number of elements greater than 100 is even.
     * This demonstrates point-free style: even . length . greaterThan100
     */
    public static boolean myTest(List<Integer> xs) {
        // even . length . greaterThan100
        return isEven(length(greaterThan100(xs)));
    }

    /**
     * Generic filter function that applies a predicate to each element.
     * This is a higher-order function that takes a function as an argument.
     */
    public static <T> List<T> filter(List<T> xs, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T x : xs) {
            if (predicate.test(x)) {
                result.add(x);
            }
        }
        return result;
    }

    /**
     * Generic map function that applies a function to each element.
     * This is another higher-order function.
     */
    public static <T, R> List<R> map(List<T> xs, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T x : xs) {
            result.add(f.apply(x));
        }
        return result;
    }

    /**
     * Helper function to check if a number is even.
     */
    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * Helper function to get the length of a list.
     */
    private static <T> int length(List<T> xs) {
        return xs.size();
    }
}