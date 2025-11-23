package info.jab.eulerproblems.eulerproblem2;

/**
 * Solution for Euler Problem 2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 * 
 * The Fibonacci sequence starts with 1 and 2, and each subsequent term is 
 * the sum of the previous two terms: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued terms in the Fibonacci sequence
     * whose values do not exceed the specified maximum value.
     * 
     * @param maxValue the maximum value for Fibonacci terms to consider
     * @return the sum of all even-valued Fibonacci terms not exceeding maxValue
     */
    public long sumEvenFibonacciTerms(long maxValue) {
        if (maxValue < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 2;

        // The first even term is 2
        if (second <= maxValue) {
            sum += second;
        }

        // Generate Fibonacci sequence and sum even terms
        while (true) {
            long next = first + second;
            
            // Stop if next term exceeds the maximum value
            if (next > maxValue) {
                break;
            }

            // Add even terms to the sum
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
