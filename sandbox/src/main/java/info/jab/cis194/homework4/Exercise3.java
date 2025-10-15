package info.jab.cis194.homework4;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise3 {

    /**
     * Right fold: foldr f z [a,b,c] = a `f` (b `f` (c `f` z))
     * This is the Java equivalent of Haskell's foldr function.
     * 
     * Type: (a -> b -> b) -> b -> [a] -> b
     */
    public static <A, B> B foldr(BiFunction<A, B, B> f, B z, List<A> xs) {
        if (xs.isEmpty()) {
            return z;
        } else {
            A head = xs.get(0);
            List<A> tail = xs.subList(1, xs.size());
            return f.apply(head, foldr(f, z, tail));
        }
    }

    /**
     * Left fold: foldl f z [a,b,c] = ((z `f` a) `f` b) `f` c
     * This is the Java equivalent of Haskell's foldl function.
     * 
     * Type: (b -> a -> b) -> b -> [a] -> b
     */
    public static <A, B> B foldl(BiFunction<B, A, B> f, B z, List<A> xs) {
        B acc = z;
        for (A x : xs) {
            acc = f.apply(acc, x);
        }
        return acc;
    }

    /**
     * Sum of a list of integers using foldr.
     * sum [a,b,c] = a + (b + (c + 0))
     */
    public static int sum(List<Integer> xs) {
        return foldr((x, y) -> x + y, 0, xs);
    }

    /**
     * Product of a list of integers using foldr.
     * product [a,b,c] = a * (b * (c * 1))
     */
    public static int product(List<Integer> xs) {
        return foldr((x, y) -> x * y, 1, xs);
    }

    /**
     * Length of a list using foldr.
     * length [a,b,c] = 1 + (1 + (1 + 0))
     */
    public static <A> int length(List<A> xs) {
        return foldr((x, y) -> 1 + y, 0, xs);
    }

    /**
     * Check if all elements satisfy a predicate using foldr.
     * all p [a,b,c] = p a && (p b && (p c && True))
     */
    public static <A> boolean all(Predicate<A> p, List<A> xs) {
        return foldr((x, y) -> p.test(x) && y, true, xs);
    }

    /**
     * Check if any element satisfies a predicate using foldr.
     * any p [a,b,c] = p a || (p b || (p c || False))
     */
    public static <A> boolean any(Predicate<A> p, List<A> xs) {
        return foldr((x, y) -> p.test(x) || y, false, xs);
    }

    /**
     * Reverse a list using foldl.
     * reverse [a,b,c] = foldl (flip (:)) [] [a,b,c]
     */
    public static <A> List<A> reverse(List<A> xs) {
        return foldl((List<A> acc, A x) -> {
            List<A> result = new ArrayList<>();
            result.add(x);
            result.addAll(acc);
            return result;
        }, new ArrayList<>(), xs);
    }

    /**
     * Concatenate a list of lists using foldr.
     * concat [[a,b],[c,d],[e,f]] = a : (b : (c : (d : (e : (f : [])))))
     */
    public static <A> List<A> concat(List<List<A>> xss) {
        return foldr((List<A> xs, List<A> acc) -> {
            List<A> result = new ArrayList<>(xs);
            result.addAll(acc);
            return result;
        }, new ArrayList<>(), xss);
    }

    /**
     * Map function implemented using foldr.
     * map f [a,b,c] = f a : (f b : (f c : []))
     */
    public static <A, B> List<B> mapWithFold(Function<A, B> f, List<A> xs) {
        return foldr((A x, List<B> acc) -> {
            List<B> result = new ArrayList<>();
            result.add(f.apply(x));
            result.addAll(acc);
            return result;
        }, new ArrayList<>(), xs);
    }

    /**
     * Filter function implemented using foldr.
     * filter p [a,b,c] = if p a then a : (if p b then b : (if p c then c : [] else []) else []) else (if p b then b : (if p c then c : [] else []) else (if p c then c : [] else []))
     */
    public static <A> List<A> filterWithFold(Predicate<A> p, List<A> xs) {
        return foldr((A x, List<A> acc) -> {
            if (p.test(x)) {
                List<A> result = new ArrayList<>();
                result.add(x);
                result.addAll(acc);
                return result;
            } else {
                return acc;
            }
        }, new ArrayList<>(), xs);
    }
}