package info.jab.eulerproblems.eulerproblem10;

import java.util.Arrays;

/**
 * Solution for Euler Problem 10: Summation of primes
 * 
 * Problem: Find the sum of all the primes below two million.
 * 
 * This solution uses the Sieve of Eratosthenes algorithm to efficiently
 * find all prime numbers below the given limit.
 */
public class EulerProblem10 {

    /**
     * Calculates the sum of all prime numbers below the given limit.
     * 
     * @param limit the upper bound (exclusive)
     * @return the sum of all primes below the limit
     */
    public long sumOfPrimesBelow(int limit) {
        if (limit <= 2) {
            return 0L;
        }

        // Use Sieve of Eratosthenes to find all primes
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        
        // 0 and 1 are not primes
        isPrime[0] = false;
        isPrime[1] = false;

        // Mark multiples of primes as composite
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Sum all primes
        long sum = 0L;
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }

        return sum;
    }
}
