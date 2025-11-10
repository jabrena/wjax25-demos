package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2.
 * Problem: By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 * 
 * The Fibonacci sequence starts with 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * Even terms: 2, 8, 34, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued terms in the Fibonacci sequence
     * whose values do not exceed the given limit.
     * 
     * @param limit the maximum value for Fibonacci terms to consider
     * @return the sum of even-valued Fibonacci terms up to the limit
     */
    public long sumEvenFibonacciTerms(long limit) {
        if (limit < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 2;

        // The second term (2) is even, so we include it
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

            // Add to sum if the term is even
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
