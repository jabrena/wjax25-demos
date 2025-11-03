package info.jab.eulerproblems.eulerproblem2;

/**
 * Solution for Euler Problem 2.
 * Problem: Find the sum of the even-valued terms in the Fibonacci sequence
 * whose values do not exceed four million.
 * 
 * The Fibonacci sequence starting with 1 and 2 is: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of all even Fibonacci numbers that are less than the given limit.
     * 
     * @param limit the maximum value (exclusive) for Fibonacci numbers to consider
     * @return the sum of all even Fibonacci numbers below the limit
     */
    public static long sumOfEvenFibonacciNumbers(long limit) {
        if (limit < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 2;

        // Process the first two Fibonacci numbers
        // Only second (2) is even, so add it to the sum
        if (second < limit) {
            sum += second;
        }

        // Generate Fibonacci numbers and sum even ones
        while (true) {
            long next = first + second;
            
            // Stop if we exceed the limit
            if (next >= limit) {
                break;
            }

            // Add even Fibonacci numbers to the sum
            if (next % 2 == 0) {
                sum += next;
            }

            // Move to next pair
            first = second;
            second = next;
        }

        return sum;
    }
}
