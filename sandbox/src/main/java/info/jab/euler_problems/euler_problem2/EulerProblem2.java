package info.jab.euler_problems.euler_problem2;

/**
 * Solution for Euler Problem 2:
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 * 
 * The Fibonacci sequence starts with 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * Even terms: 2, 8, 34, ...
 */
public class EulerProblem2 {

    /**
     * Calculates the sum of all even Fibonacci numbers that do not exceed the given limit.
     * 
     * @param limit the maximum value for Fibonacci numbers to consider
     * @return the sum of even Fibonacci numbers up to the limit
     */
    public long sumEvenFibonacciNumbers(long limit) {
        long sum = 0;
        long first = 1;
        long second = 2;
        
        // Process Fibonacci sequence
        while (second <= limit) {
            // Add even numbers to the sum
            if (second % 2 == 0) {
                sum += second;
            }
            
            // Calculate next Fibonacci number
            long next = first + second;
            first = second;
            second = next;
        }
        
        return sum;
    }
}
