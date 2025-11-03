package info.jab.euler_problems.euler_problem10;

/**
 * Euler Problem 10: Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * This solution uses the Sieve of Eratosthenes algorithm for efficient
 * prime number generation.
 */
public class EulerProblem10 {

    /**
     * Calculates the sum of all prime numbers below the given limit.
     * 
     * @param limit the upper limit (exclusive)
     * @return the sum of all primes below the limit
     */
    public static long sumOfPrimesBelow(long limit) {
        if (limit <= 2) {
            return 0;
        }

        // Use Sieve of Eratosthenes to find all primes
        boolean[] isComposite = new boolean[(int) limit];
        
        // Mark multiples of each prime starting from 2
        for (int i = 2; i * i < limit; i++) {
            if (!isComposite[i]) {
                // i is prime, mark all its multiples as composite
                for (int j = i * i; j < limit; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Sum all prime numbers
        long sum = 0;
        for (int i = 2; i < limit; i++) {
            if (!isComposite[i]) {
                sum += i;
            }
        }

        return sum;
    }
}
