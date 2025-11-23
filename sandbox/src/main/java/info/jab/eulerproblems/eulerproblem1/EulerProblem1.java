package info.jab.eulerproblems.eulerproblem1;

/**
 * Solution for Euler Problem 1.
 * 
 * Problem: Find the sum of all multiples of 3 or 5 below 1000.
 * 
 * Example: If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Solution approach:
 * We iterate through all numbers from 1 to (limit - 1) and check if each number
 * is a multiple of 3 or 5. If so, we add it to the sum.
 * 
 * Optimization note: We could use the inclusion-exclusion principle with arithmetic
 * series formulas, but for clarity and the given problem size, a simple iteration
 * is sufficient and more readable.
 */
public class EulerProblem1 {

    /**
     * Calculates the sum of all multiples of 3 or 5 below the given limit.
     * 
     * @param limit the upper bound (exclusive)
     * @return the sum of all multiples of 3 or 5 below the limit
     */
    public long sumMultiplesOf3Or5(int limit) {
        if (limit <= 0) {
            return 0;
        }

        long sum = 0;
        
        for (int i = 1; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
}
