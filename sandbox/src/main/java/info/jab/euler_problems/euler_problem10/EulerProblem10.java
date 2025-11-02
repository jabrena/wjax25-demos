package info.jab.euler_problems.euler_problem10;

/**
 * Euler Problem 10: Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * Solution uses the Sieve of Eratosthenes algorithm for efficient prime generation.
 */
public class EulerProblem10 {

    /**
     * Calculates the sum of all primes below the given limit.
     * 
     * @param limit the upper bound (exclusive) for prime numbers
     * @return the sum of all primes below the limit
     */
    public long sumOfPrimesBelow(int limit) {
        if (limit <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[limit];
        // Initialize all numbers as prime
        for (int i = 2; i < limit; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as composite
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Sum all primes
        long sum = 0;
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }

        return sum;
    }
}
