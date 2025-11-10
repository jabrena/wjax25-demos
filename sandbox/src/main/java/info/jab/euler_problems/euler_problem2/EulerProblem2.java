package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2.
 * Problem: By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 * 
 * The Fibonacci sequence starts: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 * Even terms: 2, 8, 34, 144, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of all even-valued Fibonacci numbers that do not exceed the given limit.
     * 
     * @param limit the maximum value for Fibonacci numbers to consider
     * @return the sum of all even Fibonacci numbers up to the limit
     */
    public long sumEvenFibonacciNumbers(long limit) {
        if (limit < 2) {
            return 0L;
        }

        long sum = 0L;
        long prev = 1L;
        long current = 1L;

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
