package info.jab.euler_problems.euler_problem3;

/**
 * Solution for Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Algorithm:
 * - Start from 2 and iterate up to sqrt(n)
 * - Divide n by each prime factor found
 * - Continue until n becomes 1 or a prime number
 * - Return the largest factor found
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of the given number.
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor
     */
    public long largestPrimeFactor(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be at least 2");
        }

        long largestFactor = 1;
        long n = number;

        // Check for factor 2
        while (n % 2 == 0) {
            largestFactor = 2;
            n /= 2;
        }

        // Check for odd factors starting from 3
        // Only need to check up to sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                largestFactor = i;
                n /= i;
            }
        }

        // If n is still greater than 2, it's a prime number itself
        if (n > 2) {
            largestFactor = n;
        }

        return largestFactor;
    }
}
