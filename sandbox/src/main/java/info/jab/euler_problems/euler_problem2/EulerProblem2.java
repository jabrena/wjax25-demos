package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem #2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 * 
 * Solution approach:
 * The Fibonacci sequence: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 * Even terms occur at positions: 2, 5, 8, 11, ... (every 3rd term starting from position 2)
 * 
 * We can efficiently compute even Fibonacci numbers using the property that:
 * Every 3rd Fibonacci number is even. We can use the recurrence:
 * F(n) = 4 * F(n-3) + F(n-6) for even Fibonacci numbers
 * 
 * Alternatively, we can iterate through all Fibonacci numbers and sum only the even ones.
 */
public class EulerProblem2 {

    private static final long DEFAULT_LIMIT = 4_000_000L;

    /**
     * Solves Euler Problem #2 with the default limit of 4,000,000.
     * 
     * @return the sum of even-valued Fibonacci terms not exceeding 4,000,000
     */
    public long solve() {
        return solve(DEFAULT_LIMIT);
    }

    /**
     * Solves the problem with a custom limit.
     * 
     * @param limit the maximum value for Fibonacci terms
     * @return the sum of even-valued Fibonacci terms not exceeding the limit
     */
    public long solve(long limit) {
        if (limit < 2) {
            return 0;
        }

        long sum = 0;
        long prev = 1;
        long current = 2;

        // Process Fibonacci sequence and sum even terms
        while (current <= limit) {
            if (current % 2 == 0) {
                sum += current;
            }
            
            long next = prev + current;
            prev = current;
            current = next;
        }

        return sum;
    }
}
