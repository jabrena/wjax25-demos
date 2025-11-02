package info.jab.eulerproblems.eulerproblem7;

/**
 * Euler Problem 7: What is the 10,001st prime number?
 * 
 * This class provides a method to find the nth prime number using
 * the Sieve of Eratosthenes algorithm for efficiency.
 */
public class EulerProblem7 {

    /**
     * Finds the nth prime number.
     * 
     * @param n the position of the prime number to find (1-indexed)
     * @return the nth prime number
     */
    public long getNthPrime(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Position must be positive");
        }

        if (n == 1) {
            return 2L;
        }

        // Use an estimated upper bound for the nth prime
        // Using approximation: nth prime is approximately n * ln(n) + n * ln(ln(n))
        // Adding a buffer for safety
        int upperBound = (int) (n * (Math.log(n) + Math.log(Math.log(n))) * 1.2) + 100;
        if (upperBound < 100) {
            upperBound = 100;
        }

        return sieveOfEratosthenes(upperBound, n);
    }

    /**
     * Finds the nth prime using the Sieve of Eratosthenes algorithm.
     * 
     * @param upperBound the upper bound for the sieve
     * @param n the position of the prime to find
     * @return the nth prime number
     */
    private long sieveOfEratosthenes(int upperBound, int n) {
        boolean[] isPrime = new boolean[upperBound + 1];
        
        // Initialize all numbers as prime
        for (int i = 2; i <= upperBound; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= upperBound; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= upperBound; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect primes in order
        int count = 0;
        for (int i = 2; i <= upperBound; i++) {
            if (isPrime[i]) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }

        // If we didn't find enough primes, extend the search
        // This shouldn't happen with proper upper bound, but handle it just in case
        throw new IllegalStateException("Not enough primes found. Increase upper bound.");
    }
}
