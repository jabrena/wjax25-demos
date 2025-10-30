package info.jab.cis194.homework4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class Exercise3 {

    private Exercise3() {}

    // xor implemented via fold (reduce)
    public static boolean xor(List<Boolean> values) {
        Objects.requireNonNull(values, "values");
        boolean acc = false;
        for (Boolean b : values) {
            acc = acc ^ Boolean.TRUE.equals(b);
        }
        return acc;
    }

    // map' as a foldr
    public static <A, B> List<B> mapPrime(Function<A, B> f, List<A> xs) {
        Objects.requireNonNull(f, "f");
        Objects.requireNonNull(xs, "xs");
        // foldr: process from right to left
        List<B> result = new ArrayList<>(xs.size());
        // Use a stack to emulate right fold
        Deque<A> stack = new ArrayDeque<>(xs);
        List<A> reversed = new ArrayList<>(stack);
        for (int i = reversed.size() - 1; i >= 0; i--) {
            result.add(0, f.apply(reversed.get(i)));
        }
        return result;
    }

    // myFoldl using foldr idea; in Java implement straightforward left fold
    public static <A, B> A myFoldl(BiFunction<A, B, A> f, A base, List<B> xs) {
        Objects.requireNonNull(f, "f");
        Objects.requireNonNull(xs, "xs");
        A acc = base;
        for (B x : xs) {
            acc = f.apply(acc, x);
        }
        return acc;
    }
}
