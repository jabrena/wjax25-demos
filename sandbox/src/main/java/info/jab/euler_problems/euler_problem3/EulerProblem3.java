package info.jab.euler_problems.euler_problem3;

/**
 * Solution for Euler Problem 3: Largest Prime Factor
 * 
 * Problem statement:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Algorithm:
 * We use trial division to find prime factors. We start from 2 and divide
 * the number by each prime factor we find. We continue until we've divided
 * by all factors less than or equal to the square root of the remaining number.
 * The remaining number (if > 1) is also a prime factor.
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of the given number.
     * 
     * @param number the number to find the largest prime factor for
     * @return the largest prime factor
     */
    public long largestPrimeFactor(long number) {
        if (number <= 1) {
            throw new IllegalArgumentException("Number must be greater than 1");
        }

        long largestPrime = 2;
        long remaining = number;

        // Remove all factors of 2
        while (remaining % 2 == 0) {
            largestPrime = 2;
            remaining /= 2;
        }

        // Check odd numbers starting from 3
        // We only need to check up to sqrt(remaining) since any factor
        // larger than sqrt(remaining) would have a corresponding factor
        // smaller than sqrt(remaining)
        for (long i = 3; i * i <= remaining; i += 2) {
            while (remaining % i == 0) {
                largestPrime = i;
                remaining /= i;
            }
        }

        // If remaining is greater than 2, it's a prime number itself
        // and is the largest prime factor
        if (remaining > 2) {
            largestPrime = remaining;
        }

        return largestPrime;
    }
}
