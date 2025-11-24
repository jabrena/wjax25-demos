package info.jab.euler_problems.euler_problem1;

/**
 * Problem 1: Multiples of 3 or 5
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class EulerProblem1 {

    /**
     * Calculates the sum of all multiples of 3 or 5 below the given limit.
     * 
     * @param limit the upper bound (exclusive)
     * @return the sum of all multiples of 3 or 5 below the limit
     */
    public long solve(int limit) {
        long sum = 0;
        
        for (int i = 1; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
}
