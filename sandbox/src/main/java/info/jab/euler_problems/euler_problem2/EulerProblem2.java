package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2.
 * Problem: Find the sum of even-valued terms in the Fibonacci sequence
 * whose values do not exceed four million.
 * 
 * The Fibonacci sequence starting with 1 and 2: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * We need to sum all even-valued terms that do not exceed the given maximum value.
 */
public class EulerProblem2 {

    /**
     * Solves the problem by finding the sum of even-valued Fibonacci terms
     * that do not exceed the given maximum value.
     * 
     * @param maxValue the maximum value for Fibonacci terms to consider
     * @return the sum of even-valued Fibonacci terms not exceeding maxValue
     */
    public long solve(long maxValue) {
        if (maxValue < 2) {
            return 0;
        }

        long sum = 0;
        long prev = 1;
        long current = 2;

        while (current <= maxValue) {
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
