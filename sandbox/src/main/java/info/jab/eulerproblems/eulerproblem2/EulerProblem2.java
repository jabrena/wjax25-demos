package info.jab.eulerproblems.eulerproblem2;

/**
 * Solution for Euler Problem #2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 * 
 * The Fibonacci sequence starting with 1 and 2: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * This implementation uses an iterative approach to generate Fibonacci numbers
 * and sums only the even-valued terms up to the specified limit.
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of even-valued Fibonacci numbers up to the given limit.
     * 
     * The Fibonacci sequence starts with 1 and 2, and each subsequent term
     * is the sum of the previous two terms.
     * 
     * @param limit the maximum value for Fibonacci numbers to consider
     * @return the sum of all even-valued Fibonacci numbers not exceeding the limit
     */
    public long sumEvenFibonacciNumbers(long limit) {
        if (limit < 2) {
            return 0;
        }

        long sum = 0;
        long first = 1;
        long second = 2;

        // Process the initial even number (2)
        if (second <= limit) {
            sum += second;
        }

        // Generate Fibonacci numbers iteratively
        while (true) {
            long next = first + second;
            
            // Stop if the next Fibonacci number exceeds the limit
            if (next > limit) {
                break;
            }

            // Add even numbers to the sum
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
