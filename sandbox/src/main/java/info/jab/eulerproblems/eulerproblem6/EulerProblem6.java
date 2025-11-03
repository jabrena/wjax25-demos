package info.jab.eulerproblems.eulerproblem6;

/**
 * Solution for Project Euler Problem 6: Sum Square Difference
 * 
 * Problem: Find the difference between the sum of the squares of the first 
 * one hundred natural numbers and the square of the sum.
 * 
 * For n natural numbers:
 * - Sum of squares: 1² + 2² + ... + n² = n(n+1)(2n+1)/6
 * - Square of sum: (1 + 2 + ... + n)² = [n(n+1)/2]²
 * - Difference: Square of sum - Sum of squares
 */
public class EulerProblem6 {

    /**
     * Calculates the difference between the square of the sum and the sum of squares
     * for the first n natural numbers.
     * 
     * @param n the number of natural numbers to consider
     * @return the difference between the square of the sum and the sum of squares
     */
    public long calculateDifference(int n) {
        if (n <= 0) {
            return 0;
        }

        long sum = n * (n + 1L) / 2L;  // Sum of first n natural numbers: n(n+1)/2
        long squareOfSum = sum * sum;  // Square of the sum

        // Sum of squares: n(n+1)(2n+1)/6
        long sumOfSquares = n * (n + 1L) * (2L * n + 1L) / 6L;

        return squareOfSum - sumOfSquares;
    }
}
