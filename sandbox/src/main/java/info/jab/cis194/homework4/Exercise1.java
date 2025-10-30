package info.jab.cis194.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;

public final class Exercise1 {

    private Exercise1() {}

    // fun1' :: [Integer] -> Integer
    // Multiply (x - 2) for every even x, ignore odds; empty -> 1
    public static long fun1Prime(List<Long> values) {
        Objects.requireNonNull(values, "values");
        return values.stream()
                .filter(v -> v % 2 == 0)
                .mapToLong(v -> v - 2)
                .reduce(1L, (a, b) -> a * b);
    }

    // fun2' :: Integer -> Integer using wholemeal style
    // Sum all even values in the Collatz sequence until reaching 1
    public static long fun2Prime(long n) {
        if (n < 1) throw new IllegalArgumentException("n must be >= 1");
        return collatzSequence(n).stream()
                .takeWhile(x -> x != 1L)
                .filter(x -> x % 2 == 0)
                .mapToLong(Long::longValue)
                .sum();
    }

    // Expose sequence for testing/reference
    static List<Long> collatzSequence(long start) {
        if (start < 1) throw new IllegalArgumentException("start must be >= 1");
        LongUnaryOperator step = x -> (x % 2 == 0) ? (x / 2) : (3 * x + 1);
        // include the starting value, then iterate until hitting 1 (inclusive)
        List<Long> result = new ArrayList<>();
        long current = start;
        result.add(current);
        while (current != 1) {
            current = step.applyAsLong(current);
            result.add(current);
        }
        return result;
    }
}
