package info.jab.euler_problems.euler_problem7;

/**
 * Solution for Euler Problem 7: 10001st Prime
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * 
 * What is the 10,001st prime number?
 */
public class EulerProblem7 {

    /**
     * Finds the nth prime number.
     * 
     * @param n the position of the prime number (1-indexed)
     * @return the nth prime number
     */
    public long findNthPrime(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        
        if (n == 1) {
            return 2L;
        }
        
        int count = 1; // We already have 2
        long candidate = 3; // Start checking from 3
        
        while (count < n) {
            if (isPrime(candidate)) {
                count++;
                if (count == n) {
                    return candidate;
                }
            }
            candidate += 2; // Only check odd numbers
        }
        
        return candidate;
    }
    
    /**
     * Checks if a number is prime using trial division.
     * 
     * @param number the number to check
     * @return true if the number is prime, false otherwise
     */
    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        
        if (number == 2) {
            return true;
        }
        
        if (number % 2 == 0) {
            return false;
        }
        
        // Check divisibility up to sqrt(number)
        long sqrt = (long) Math.sqrt(number);
        for (long i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
