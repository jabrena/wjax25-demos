package info.jab.cis194.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Exercise4 {

    /**
     * Implements the Sieve of Sundaram to find all odd prime numbers up to 2n + 2.
     * 
     * The Sieve of Sundaram works by:
     * 1. Create a list of integers from 1 to n
     * 2. For each i from 1 to n, and for each j from i to n such that i + j + 2ij <= n,
     *    mark the number i + j + 2ij as composite
     * 3. The remaining unmarked numbers, when doubled and incremented by 1, give the odd primes
     * 
     * @param n The parameter for the sieve
     * @return List of odd prime numbers up to 2n + 2
     */
    public static List<Integer> sieveSundaram(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        // Create a set to mark composite numbers
        Set<Integer> composites = new HashSet<>();
        
        // Apply the Sieve of Sundaram algorithm
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int candidate = i + j + 2 * i * j;
                if (candidate <= n) {
                    composites.add(candidate);
                } else {
                    break; // Since j is increasing, we can break early
                }
            }
        }

        // Generate the odd primes
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!composites.contains(i)) {
                // The odd prime is 2*i + 1
                primes.add(2 * i + 1);
            }
        }

        return primes;
    }

    /**
     * Alternative implementation using a more functional approach with streams.
     */
    public static List<Integer> sieveSundaramFunctional(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        // Generate all composite numbers using the Sundaram formula
        Set<Integer> composites = new HashSet<>();
        
        // Use streams to generate all composite numbers
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int candidate = i + j + 2 * i * j;
                if (candidate <= n) {
                    composites.add(candidate);
                } else {
                    break;
                }
            }
        }

        // Generate primes using streams
        return java.util.stream.IntStream.rangeClosed(1, n)
                .filter(i -> !composites.contains(i))
                .map(i -> 2 * i + 1)
                .boxed()
                .collect(java.util.stream.Collectors.toList());
    }

    /**
     * Cartesian product of two lists.
     * 
     * @param xs First list
     * @param ys Second list
     * @return List of all possible pairs (x, y) where x is from xs and y is from ys
     */
    public static <A, B> List<Pair<A, B>> cartProd(List<A> xs, List<B> ys) {
        List<Pair<A, B>> result = new ArrayList<>();
        
        for (A x : xs) {
            for (B y : ys) {
                result.add(new Pair<>(x, y));
            }
        }
        
        return result;
    }

    /**
     * Simple pair class to represent tuples.
     */
    public static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            
            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
}