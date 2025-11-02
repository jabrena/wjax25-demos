package info.jab.euler_problems.euler_problem1;

/**
 * Solution for Euler Problem 1: Multiples of 3 or 5.
 * 
 * Problem: Find the sum of all multiples of 3 or 5 below a given limit.
 * 
 * For example, if the limit is 10, the multiples of 3 or 5 below 10 are:
 * 3, 5, 6, 9, and their sum is 23.
 */
public class EulerProblem1 {

    /**
     * Calculates the sum of all multiples of 3 or 5 below the given limit.
     * 
     * @param limit the upper bound (exclusive)
     * @return the sum of all multiples of 3 or 5 below the limit
     */
    public long sumOfMultiples(int limit) {
        if (limit <= 3) {
            return 0L;
        }

        long sum = 0L;
        
        for (int i = 3; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
}
