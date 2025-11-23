package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 * 
 * The Fibonacci sequence starts with 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * We need to sum only the even-valued terms that do not exceed the limit.
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued terms in the Fibonacci sequence
     * that do not exceed the specified limit.
     * 
     * @param limit the maximum value for Fibonacci terms to consider
     * @return the sum of even-valued Fibonacci terms not exceeding the limit
     */
    public long sumEvenFibonacciTerms(long limit) {
        if (limit < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 2;

        // Process the Fibonacci sequence
        while (second <= limit) {
            // Add even terms to the sum
            if (second % 2 == 0) {
                sum += second;
            }

            // Calculate next Fibonacci number
            long next = first + second;
            first = second;
            second = next;
        }

        return sum;
    }
}
