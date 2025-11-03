package info.jab.eulerProblems.eulerProblem1;

/**
 * Solution for Euler Problem 1.
 * 
 * Problem: Find the sum of all multiples of 3 or 5 below a given limit.
 * Example: For numbers below 10, we get 3, 5, 6, 9 which sum to 23.
 * 
 * The solution iterates through all numbers from 1 to limit-1 and sums those
 * that are divisible by 3 or 5.
 */
public class EulerProblem1 {

    /**
     * Calculates the sum of all multiples of 3 or 5 below the given limit.
     * 
     * @param limit the upper bound (exclusive)
     * @return the sum of all multiples of 3 or 5 below the limit
     */
    public long solve(int limit) {
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
