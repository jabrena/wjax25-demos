package info.jab.eulerproblems.eulerproblem3;

/**
 * Solution for Euler Problem 3: Largest Prime Factor
 * 
 * Problem statement:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Algorithm:
 * To find the largest prime factor, we:
 * 1. Start with the smallest prime factor (2)
 * 2. Divide the number by this factor as many times as possible
 * 3. Move to the next potential factor
 * 4. Continue until the number is reduced to 1 or a prime
 * 5. The last factor found is the largest prime factor
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor
     * @throws IllegalArgumentException if the number is less than 2
     */
    public long findLargestPrimeFactor(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be at least 2");
        }

        long largestPrimeFactor = 1;
        long n = number;

        // Handle the case when the number is even
        while (n % 2 == 0) {
            largestPrimeFactor = 2;
            n /= 2;
        }

        // Check for odd factors starting from 3
        // We only need to check up to sqrt(n) because any factor larger than sqrt(n)
        // would have a corresponding factor smaller than sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                largestPrimeFactor = i;
                n /= i;
            }
        }

        // If n is still greater than 2, it means n itself is a prime number
        // and is the largest prime factor
        if (n > 2) {
            largestPrimeFactor = n;
        }

        return largestPrimeFactor;
    }
}
