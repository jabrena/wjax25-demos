package info.jab.eulerproblem2;

/**
 * Solution for Euler Problem 2.
 * 
 * Problem: Find the sum of even-valued terms in the Fibonacci sequence
 * whose values do not exceed four million.
 * 
 * The Fibonacci sequence starts with 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * We need to sum only the even terms (2, 8, 34, ...) that are less than 4,000,000.
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued terms in the Fibonacci sequence
     * whose values do not exceed the given limit.
     * 
     * @param limit the maximum value for Fibonacci terms to consider
     * @return the sum of even Fibonacci terms up to the limit
     */
    public long sumEvenFibonacciTerms(long limit) {
        if (limit < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 2;

        // Start with second term (2) which is even
        if (second <= limit) {
            sum += second;
        }

        // Generate Fibonacci sequence and sum even terms
        while (true) {
            long next = first + second;
            
            // Stop if next term exceeds limit
            if (next > limit) {
                break;
            }

            // Add to sum if even
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
