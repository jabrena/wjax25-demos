package info.jab.cis194.homework4;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    /**
     * Original fun1 implementation
     */
    public int fun1(List<Integer> xs) {
        if (xs.isEmpty()) {
            return 1;
        }
        
        int x = xs.get(0);
        List<Integer> rest = xs.subList(1, xs.size());
        
        if (x % 2 == 0) {
            return (x - 2) * fun1(rest);
        } else {
            return fun1(rest);
        }
    }

    /**
     * Wholemeal programming version of fun1
     * Uses functional programming style with streams
     */
    public int fun1Prime(List<Integer> xs) {
        return xs.stream()
                .filter(x -> x % 2 == 0)  // Keep only even numbers
                .map(x -> x - 2)          // Transform each even number
                .reduce(1, (a, b) -> a * b); // Multiply all results together
    }

    /**
     * Original fun2 implementation
     */
    public int fun2(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return n + fun2(n / 2);
        } else {
            return fun2(3 * n + 1);
        }
    }

    /**
     * Wholemeal programming version of fun2
     * Uses iterate and takeWhile to generate the sequence
     */
    public int fun2Prime(int n) {
        if (n == 1) {
            return 0;
        }
        
        // Generate the sequence starting from n, but only include numbers that are even
        // or the final 1 (which we'll handle separately)
        return java.util.stream.Stream.iterate(n, x -> x != 1, x -> 
            x % 2 == 0 ? x / 2 : 3 * x + 1)
            .filter(x -> x % 2 == 0)  // Only include even numbers in the sum
            .mapToInt(Integer::intValue)
            .sum();
    }
}