package info.jab.eulerproblems.eulerproblem2;

/**
 * Solution for Euler Problem 2.
 * Problem: Find the sum of even-valued terms in the Fibonacci sequence
 * (starting with 1 and 2) whose values do not exceed four million.
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued terms in the Fibonacci sequence
     * starting with 1 and 2, where terms do not exceed the given limit.
     *
     * @param limit the maximum value for Fibonacci terms to consider
     * @return the sum of all even-valued Fibonacci terms up to the limit
     */
    public long sumEvenFibonacciTerms(long limit) {
        if (limit < 2) {
            return 0L;
        }

        long sum = 0L;
        long first = 1L;
        long second = 2L;

        // Process the initial even term (2)
        if (second <= limit) {
            sum += second;
        }

        // Generate Fibonacci sequence and sum even terms
        while (true) {
            long next = first + second;
            
            // Stop if next term exceeds the limit
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