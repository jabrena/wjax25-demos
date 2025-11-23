package info.jab.euler_problems.euler_problem3;

/**
 * Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Solution approach:
 * - Start from 2 and iterate through potential factors
 * - For each factor found, divide the number by it repeatedly until it's no longer divisible
 * - The last factor found will be the largest prime factor
 * - We only need to check up to sqrt(n) since any factor larger than sqrt(n) 
 *   would have a corresponding factor smaller than sqrt(n)
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor
     */
    public long largestPrimeFactor(long number) {
        if (number <= 1) {
            throw new IllegalArgumentException("Number must be greater than 1");
        }

        long largestPrime = 2;
        long n = number;

        // Handle the case when the number is even
        while (n % 2 == 0) {
            largestPrime = 2;
            n /= 2;
        }

        // Check odd factors starting from 3
        // We only need to check up to sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                largestPrime = i;
                n /= i;
            }
        }

        // If n is still greater than 2, it means n itself is a prime number
        // and is the largest prime factor
        if (n > 2) {
            largestPrime = n;
        }

        return largestPrime;
    }
}
