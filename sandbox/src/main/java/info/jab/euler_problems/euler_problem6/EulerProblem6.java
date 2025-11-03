package info.jab.euler_problems.euler_problem6;

/**
 * Solution for Euler Problem 6.
 * Problem: Find the difference between the sum of the squares of the first 
 * one hundred natural numbers and the square of the sum.
 * 
 * The difference is calculated as: (square of sum) - (sum of squares)
 * 
 * Formulas:
 * - Sum of squares: 1? + 2? + ... + n? = n(n+1)(2n+1)/6
 * - Square of sum: (1 + 2 + ... + n)? = (n(n+1)/2)?
 */
public class EulerProblem6 {

    /**
     * Calculates the difference between the square of the sum and the sum of squares
     * for the first n natural numbers.
     * 
     * @param n the number of natural numbers to consider
     * @return the difference (square of sum) - (sum of squares)
     */
    public long calculateDifference(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive integer");
        }

        long squareOfSum = calculateSquareOfSum(n);
        long sumOfSquares = calculateSumOfSquares(n);
        
        return squareOfSum - sumOfSquares;
    }

    /**
     * Calculates the square of the sum of the first n natural numbers.
     * Formula: (1 + 2 + ... + n)? = (n(n+1)/2)?
     * 
     * @param n the number of natural numbers
     * @return the square of the sum
     */
    private long calculateSquareOfSum(int n) {
        long sum = (long) n * (n + 1) / 2;
        return sum * sum;
    }

    /**
     * Calculates the sum of squares of the first n natural numbers.
     * Formula: 1? + 2? + ... + n? = n(n+1)(2n+1)/6
     * 
     * @param n the number of natural numbers
     * @return the sum of squares
     */
    private long calculateSumOfSquares(int n) {
        return (long) n * (n + 1) * (2L * n + 1) / 6;
    }
}
