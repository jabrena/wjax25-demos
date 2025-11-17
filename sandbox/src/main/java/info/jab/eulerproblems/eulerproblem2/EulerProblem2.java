package info.jab.eulerproblems.eulerproblem2;

/**
 * Solution for Euler Problem 2.
 * Problem: By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 *
 * The Fibonacci sequence starts: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 * Even values: 2, 8, 34, 144, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of all even-valued terms in the Fibonacci sequence
     * that do not exceed the given limit.
     *
     * @param limit the maximum value for Fibonacci terms to consider
     * @return the sum of even-valued Fibonacci terms not exceeding the limit
     */
    public long sumEvenFibonacciNumbers(long limit) {
        if (limit < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 1;

        // Generate Fibonacci sequence and sum even values
        while (second <= limit) {
            if (second % 2 == 0) {
                sum += second;
            }
            long next = first + second;
            first = second;
            second = next;
        }

        return sum;
    }
}
