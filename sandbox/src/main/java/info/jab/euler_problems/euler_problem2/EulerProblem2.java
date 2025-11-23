package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 * 
 * The Fibonacci sequence starts with 1 and 2: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued Fibonacci numbers that do not exceed the given maximum value.
     * 
     * The Fibonacci sequence starts with 1 and 2, and each subsequent term is the sum of the previous two terms.
     * Only even-valued terms are included in the sum.
     * 
     * @param maxValue the maximum value for Fibonacci terms (inclusive)
     * @return the sum of even-valued Fibonacci numbers up to maxValue
     */
    public long sumEvenFibonacciNumbers(long maxValue) {
        if (maxValue < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 2;

        // Include the first even number (2) if it's within the limit
        if (second <= maxValue) {
            sum += second;
        }

        // Generate Fibonacci sequence and sum even numbers
        while (true) {
            long next = first + second;
            
            // Stop if the next term exceeds the maximum value
            if (next > maxValue) {
                break;
            }

            // Add to sum if the term is even
            if (next % 2 == 0) {
                sum += next;
            }

            // Move to the next pair
            first = second;
            second = next;
        }

        return sum;
    }
}
