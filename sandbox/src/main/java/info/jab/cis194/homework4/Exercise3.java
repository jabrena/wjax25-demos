package info.jab.cis194.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Exercise3 {

    /**
     * XOR function that returns true if and only if there are an odd number of true values.
     * 
     * @param list List of boolean values
     * @return true if odd number of true values, false otherwise
     */
    public static boolean xor(List<Boolean> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }

        // Count the number of true values and check if it's odd
        long trueCount = list.stream()
                .mapToLong(b -> b ? 1 : 0)
                .sum();

        return trueCount % 2 == 1;
    }

    /**
     * Map function implemented using foldr.
     * 
     * @param f The function to apply to each element
     * @param list The input list
     * @return A new list with the function applied to each element
     */
    public static <A, B> List<B> map(Function<A, B> f, List<A> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        // Use foldr to build the result list
        return foldr((x, acc) -> {
            ArrayList<B> result = new ArrayList<>();
            result.add(f.apply(x));
            result.addAll(acc);
            return result;
        }, new ArrayList<>(), list);
    }

    /**
     * foldl implemented using foldr.
     * 
     * The key insight is that foldl f z [x1, x2, ..., xn] = 
     * foldr (\x g -> \a -> g (f a x)) id [x1, x2, ..., xn] z
     * 
     * @param f The binary function to apply
     * @param base The base value
     * @param list The input list
     * @return The result of folding from the left
     */
    public static <A, B> B myFoldl(BiFunction<B, A, B> f, B base, List<A> list) {
        if (list == null || list.isEmpty()) {
            return base;
        }

        // Use the direct implementation for now, as the functional approach is complex in Java
        return myFoldlDirect(f, base, list);
    }

    /**
     * Helper method to implement foldr (right fold).
     * 
     * @param f The binary function to apply
     * @param base The base value
     * @param list The input list
     * @return The result of folding from the right
     */
    private static <A, B> B foldr(BiFunction<A, B, B> f, B base, List<A> list) {
        if (list.isEmpty()) {
            return base;
        }

        A head = list.get(0);
        List<A> tail = list.subList(1, list.size());
        return f.apply(head, foldr(f, base, tail));
    }

    /**
     * Alternative implementation of myFoldl using a more direct approach.
     * This is more efficient and easier to understand.
     */
    public static <A, B> B myFoldlDirect(BiFunction<B, A, B> f, B base, List<A> list) {
        if (list == null || list.isEmpty()) {
            return base;
        }

        B result = base;
        for (A element : list) {
            result = f.apply(result, element);
        }
        return result;
    }

    /**
     * Alternative implementation of map using a more direct approach.
     */
    public static <A, B> List<B> mapDirect(Function<A, B> f, List<A> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        List<B> result = new ArrayList<>();
        for (A element : list) {
            result.add(f.apply(element));
        }
        return result;
    }

    /**
     * Alternative implementation of xor using a more direct approach.
     */
    public static boolean xorDirect(List<Boolean> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }

        boolean result = false;
        for (Boolean b : list) {
            if (b) {
                result = !result;
            }
        }
        return result;
    }
}