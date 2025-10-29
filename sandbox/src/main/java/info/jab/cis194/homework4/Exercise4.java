package info.jab.cis194.homework4;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Exercise4 {

    /**
     * Computes the Cartesian product of two lists
     */
    public <A, B> List<Pair<A, B>> cartProd(List<A> xs, List<B> ys) {
        List<Pair<A, B>> result = new ArrayList<>();
        for (A x : xs) {
            for (B y : ys) {
                result.add(new Pair<>(x, y));
            }
        }
        return result;
    }

    /**
     * Implements the Sieve of Sundaram to find all odd prime numbers up to 2n + 2
     */
    public List<Integer> sieveSundaram(int n) {
        if (n <= 0) {
            return List.of();
        }
        
        // Create a boolean array to mark composite numbers
        boolean[] isComposite = new boolean[n + 1];
        
        // Mark numbers of the form i + j + 2ij as composite
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= (n - i) / (2 * i + 1); j++) {
                int composite = i + j + 2 * i * j;
                if (composite <= n) {
                    isComposite[composite] = true;
                }
            }
        }
        
        // Generate odd primes
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(2 * i + 1);
            }
        }
        
        return primes;
    }
}