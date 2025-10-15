package info.jab.cis194.homework4;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    /**
     * Original fun1 implementation in Haskell:
     * fun1 [] = 1
     * fun1 (x:xs) | even x = (x - 2) * fun1 xs
     *             | otherwise = fun1 xs
     * 
     * This function multiplies (x-2) for each even number x in the list.
     * If the list is empty, it returns 1.
     */
    public static int fun1(List<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        
        return list.stream()
                .filter(x -> x % 2 == 0)  // Keep only even numbers
                .mapToInt(x -> x - 2)     // Transform to (x-2)
                .reduce(1, (a, b) -> a * b); // Multiply all results, starting with 1
    }

    /**
     * Original fun2 implementation in Haskell:
     * fun2 1 = 0
     * fun2 n | even n = n + fun2 (n `div` 2)
     *        | otherwise = fun2 (3 * n + 1)
     * 
     * This is the Collatz conjecture function that sums all even numbers
     * encountered in the sequence until reaching 1.
     */
    public static int fun2(int n) {
        if (n == 1) {
            return 0;
        }
        
        if (n % 2 == 0) {
            return n + fun2(n / 2);
        } else {
            return fun2(3 * n + 1);
        }
    }
}