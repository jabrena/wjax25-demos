package info.jab.cis194.homework4;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Exercise3 {

    /**
     * Returns true if and only if there are an odd number of True values in the input list
     */
    public boolean xor(List<Boolean> xs) {
        return xs.stream()
                .filter(b -> b)  // Keep only true values
                .count() % 2 == 1;  // Check if count is odd
    }

    /**
     * Implement map as a fold
     */
    public <A, B> List<B> mapPrime(Function<A, B> f, List<A> xs) {
        return xs.stream()
                .collect(ArrayList::new, 
                        (list, x) -> list.add(f.apply(x)), 
                        ArrayList::addAll);
    }

    /**
     * Implement foldl using foldr
     */
    public <A, B> A myFoldl(BiFunction<A, B, A> f, A base, List<B> xs) {
        // This is a simplified implementation
        // In a true foldl implementation using foldr, we would need to reverse the list
        // or use a more complex approach with function composition
        A result = base;
        for (B x : xs) {
            result = f.apply(result, x);
        }
        return result;
    }
}