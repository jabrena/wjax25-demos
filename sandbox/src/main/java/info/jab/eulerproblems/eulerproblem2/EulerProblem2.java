package info.jab.eulerproblems.eulerproblem2;

/**
 * Solution for Euler Problem #2.
 * Problem: Find the sum of all even Fibonacci numbers that do not exceed four million.
 * Starting with 1 and 2, the Fibonacci sequence begins: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 * 
 * The solution iterates through Fibonacci numbers and sums only the even ones.
 */
public class EulerProblem2 {

    private static final long DEFAULT_LIMIT = 4_000_000L;

    /**
     * Solves the Euler problem #2 with the default limit of 4,000,000.
     *
     * @return the sum of all even Fibonacci numbers up to 4,000,000
     */
    public long solve() {
        return solve(DEFAULT_LIMIT);
    }

    /**
     * Solves the Euler problem #2 with a custom limit.
     * Finds the sum of all even Fibonacci numbers that do not exceed the given limit.
     *
     * @param limit the maximum value for Fibonacci numbers to consider
     * @return the sum of all even Fibonacci numbers up to the limit
     */
    public long solve(long limit) {
        long sum = 0L;
        long previous = 1L;
        long current = 2L;

        while (current <= limit) {
            // Add current Fibonacci number if it's even
            if (current % 2 == 0) {
                sum += current;
            }

            // Calculate next Fibonacci number
            long next = previous + current;
            previous = current;
            current = next;
        }

        return sum;
    }
}
