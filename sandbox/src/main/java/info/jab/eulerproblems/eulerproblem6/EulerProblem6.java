package info.jab.eulerproblems.eulerproblem6;

/**
 * Solution for Euler problem #6: Sum square difference.
 * 
 * Problem: Find the difference between the sum of the squares of the first one hundred 
 * natural numbers and the square of the sum.
 * 
 * The sum of the squares of the first n natural numbers: 1? + 2? + ... + n? = n(n+1)(2n+1)/6
 * The square of the sum of the first n natural numbers: (1 + 2 + ... + n)? = (n(n+1)/2)?
 * 
 * Difference = (n(n+1)/2)? - n(n+1)(2n+1)/6
 *            = n(n+1)[n(n+1)/4 - (2n+1)/6]
 *            = n(n+1)[(3n(n+1) - 2(2n+1))/12]
 *            = n(n+1)[(3n? + 3n - 4n - 2)/12]
 *            = n(n+1)(3n? - n - 2)/12
 *            = n(n+1)(3n-2)(n+1)/12
 * 
 * However, a simpler approach is to calculate directly:
 * - Sum of squares: n(n+1)(2n+1)/6
 * - Square of sum: (n(n+1)/2)?
 * - Difference: (n(n+1)/2)? - n(n+1)(2n+1)/6
 */
public class EulerProblem6 {

    /**
     * Calculates the difference between the square of the sum and the sum of the squares
     * of the first n natural numbers.
     * 
     * @param n the number of natural numbers to consider
     * @return the difference between the square of the sum and the sum of the squares
     */
    public long calculateSumSquareDifference(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        // Sum of squares: 1? + 2? + ... + n? = n(n+1)(2n+1)/6
        long sumOfSquares = (long) n * (n + 1) * (2L * n + 1) / 6;

        // Square of sum: (1 + 2 + ... + n)? = (n(n+1)/2)?
        long sum = (long) n * (n + 1) / 2;
        long squareOfSum = sum * sum;

        // Difference: square of sum - sum of squares
        return squareOfSum - sumOfSquares;
    }
}
