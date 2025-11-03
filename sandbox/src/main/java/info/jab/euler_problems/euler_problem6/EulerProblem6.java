package info.jab.euler_problems.euler_problem6;

/**
 * Euler Problem 6: Sum square difference
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1? + 2? + ... + 10? = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)? = 55? = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers 
 * and the square of the sum is 3025 ? 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers 
 * and the square of the sum.
 */
public class EulerProblem6 {

    /**
     * Calculates the difference between the square of the sum and the sum of squares
     * for the first n natural numbers.
     * 
     * Using mathematical formulas:
     * - Sum of squares: 1? + 2? + ... + n? = n(n+1)(2n+1)/6
     * - Square of sum: (1 + 2 + ... + n)? = [n(n+1)/2]? = n?(n+1)?/4
     * - Difference = square of sum - sum of squares
     * 
     * @param n the number of natural numbers
     * @return the difference between the square of the sum and the sum of squares
     */
    public static long calculateDifference(int n) {
        // Calculate sum of squares: n(n+1)(2n+1)/6
        long sumOfSquares = (long) n * (n + 1) * (2L * n + 1) / 6;
        
        // Calculate square of sum: [n(n+1)/2]? = n?(n+1)?/4
        long sum = (long) n * (n + 1) / 2;
        long squareOfSum = sum * sum;
        
        // Return the difference
        return squareOfSum - sumOfSquares;
    }
}
