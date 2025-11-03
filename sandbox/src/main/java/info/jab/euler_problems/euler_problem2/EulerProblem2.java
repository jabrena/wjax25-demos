package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2.
 * Problem: Find the sum of all even-valued terms in the Fibonacci sequence 
 * whose values do not exceed four million.
 * 
 * The Fibonacci sequence starts with 1 and 2, then each subsequent term
 * is the sum of the previous two terms: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of all even-valued terms in the Fibonacci sequence
     * whose values do not exceed the specified maximum value.
     * 
     * @param maxValue the maximum value for Fibonacci terms to consider
     * @return the sum of all even-valued Fibonacci terms not exceeding maxValue
     */
    public long sumEvenFibonacciTerms(long maxValue) {
        if (maxValue < 2) {
            return 0L;
        }

        long sum = 0L;
        long previous = 1L;
        long current = 2L;

        // Iterate through Fibonacci sequence
        while (current <= maxValue) {
            // Add current term if it's even
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
