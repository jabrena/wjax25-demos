package info.jab.euler_problems.euler_problem6;

/**
 * Solution for Euler Problem 6.
 * 
 * Problem: Find the difference between the sum of squares and the square of the sum
 * of the first N natural numbers.
 * 
 * For example, for the first 10 natural numbers:
 * - Sum of squares: 1? + 2? + ... + 10? = 385
 * - Square of sum: (1 + 2 + ... + 10)? = 55? = 3025
 * - Difference: 3025 - 385 = 2640
 * 
 * For the first 100 natural numbers:
 * - Sum of squares: n(n+1)(2n+1)/6
 * - Square of sum: (n(n+1)/2)?
 * - Difference: (n(n+1)/2)? - n(n+1)(2n+1)/6
 */
public class EulerProblem6 {

    /**
     * Calculates the difference between the square of the sum and the sum of squares
     * for the first n natural numbers.
     *
     * @param n the number of natural numbers to consider
     * @return the difference between (sum)? and sum of squares
     */
    public long solve(int n) {
        if (n <= 0) {
            return 0;
        }

        // Sum of first n natural numbers: n(n+1)/2
        long sum = (long) n * (n + 1) / 2;
        
        // Square of the sum
        long squareOfSum = sum * sum;
        
        // Sum of squares: n(n+1)(2n+1)/6
        long sumOfSquares = (long) n * (n + 1) * (2L * n + 1) / 6;
        
        // Return the difference
        return squareOfSum - sumOfSquares;
    }
}
