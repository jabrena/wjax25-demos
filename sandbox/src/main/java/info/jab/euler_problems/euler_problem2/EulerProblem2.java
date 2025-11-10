package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2.
 * Problem: Find the sum of even-valued Fibonacci terms that don't exceed four million.
 * 
 * The Fibonacci sequence starting with 1 and 2: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * We need to sum all even-valued terms that don't exceed the given limit.
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued Fibonacci terms that don't exceed the given limit.
     * 
     * @param limit the maximum value for Fibonacci terms to consider
     * @return the sum of even-valued Fibonacci terms up to the limit
     */
    public long sumOfEvenFibonacciTerms(long limit) {
        if (limit < 2) {
            return 0L;
        }

        long sum = 0L;
        long first = 1L;
        long second = 2L;

        // Process the first two terms
        if (second <= limit) {
            sum += second; // 2 is even
        }

        // Generate Fibonacci sequence and sum even terms
        while (true) {
            long next = first + second;
            
            if (next > limit) {
                break;
            }

            // Only add even terms
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
