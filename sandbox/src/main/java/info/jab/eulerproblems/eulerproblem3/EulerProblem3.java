package info.jab.eulerproblems.eulerproblem3;

/**
 * Solution for Euler Problem 3: Largest Prime Factor
 * 
 * Problem: What is the largest prime factor of the number 600851475143?
 * 
 * The solution uses trial division to find prime factors:
 * 1. Start with the smallest prime factor (2)
 * 2. Divide the number by the factor as long as it's divisible
 * 3. Move to the next potential factor
 * 4. The last factor found will be the largest prime factor
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

        long largestFactor = 1;
        long n = number;

        // Handle the case when number is even
        while (n % 2 == 0) {
            largestFactor = 2;
            n /= 2;
        }

        // Check for odd factors starting from 3
        // We only need to check up to sqrt(n) because any factor larger than sqrt(n)
        // would have a corresponding factor smaller than sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                largestFactor = i;
                n /= i;
            }
        }

        // If n is still greater than 2, it means n itself is a prime factor
        if (n > 2) {
            largestFactor = n;
        }

        return largestFactor;
    }
}
