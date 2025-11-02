package info.jab.euler_problems.euler_problem10;

import java.util.BitSet;

/**
 * Solution for Euler Problem 10.
 * Problem: Find the sum of all the primes below two million.
 * 
 * This implementation uses the Sieve of Eratosthenes algorithm
 * to efficiently find all primes below a given limit.
 */
public class EulerProblem10 {

    /**
     * Calculates the sum of all prime numbers below the given limit.
     *
     * @param limit the upper limit (exclusive)
     * @return the sum of all primes below the limit
     */
    public long sumOfPrimesBelow(long limit) {
        if (limit <= 2) {
            return 0;
        }

        // Use Sieve of Eratosthenes to find all primes
        BitSet isComposite = new BitSet((int) limit);
        long sum = 0;

        // Mark multiples of each prime starting from 2
        for (long i = 2; i < limit; i++) {
            if (!isComposite.get((int) i)) {
                // i is prime
                sum += i;

                // Mark all multiples of i as composite
                for (long j = i * i; j < limit; j += i) {
                    isComposite.set((int) j);
                }
            }
        }

        return sum;
    }
}
